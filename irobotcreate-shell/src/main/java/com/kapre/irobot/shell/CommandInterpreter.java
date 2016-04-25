package com.kapre.irobot.shell;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.javatuples.Pair;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class CommandInterpreter<K> {
  private enum ParameterType {
    INT,
    SHORT,
    BYTE,
    BOOL;
  }

  private final Map<String, ParameterType> commandParameterTypes = Maps
      .newLinkedHashMap();
  {
    commandParameterTypes.put("<i>", ParameterType.INT);
    commandParameterTypes.put("<s>", ParameterType.SHORT);
    commandParameterTypes.put("<b>", ParameterType.BYTE);
    commandParameterTypes.put("<f>", ParameterType.BOOL);
  }

  private Map<String, List<ParameterType>> commandParamTypeMap = Maps
      .newLinkedHashMap();
  private Map<String, Class<? extends K>> commandResultClassMap = Maps
      .newLinkedHashMap();
  private Map<String, List<?>> commandDefaultParameters = Maps
      .newLinkedHashMap();
  private Map<String, List<Class<?>>> commandDefaultParameterTypes = Maps
      .newLinkedHashMap();

  public void add(String commandName, String parameter,
      Class<? extends K> result) {
    add(commandName, parameter, result, Collections.emptyList());
  }

  public void add(String commandName, String parameter,
      Class<? extends K> result, List<?> defaultParameters) {
    if (commandName == null || commandName.trim().isEmpty()) {
      throw new IllegalArgumentException("commandName is null or empty");
    }

    if (result == null) {
      throw new IllegalArgumentException("result is null");
    }

    commandResultClassMap.put(commandName, result);
    commandParamTypeMap.put(commandName, getParameterTypes(parameter));
    commandDefaultParameters.put(commandName, defaultParameters);
    commandDefaultParameterTypes.put(commandName,
        getDefaultParameterTypes(defaultParameters));
  }

  private List<ParameterType> getParameterTypes(String parameter) {
    if (parameter == null || parameter.isEmpty()) {
      return Collections.emptyList();
    }

    List<ParameterType> parameterTypes = Lists.newArrayList();

    Scanner scanner = new Scanner(parameter);
    while (scanner.hasNext()) {
      String next = scanner.next();
      if (commandParameterTypes.containsKey(next)) {
        parameterTypes.add(commandParameterTypes.get(next));
      }
    }
    scanner.close();

    return parameterTypes;
  }

  private List<Class<?>> getDefaultParameterTypes(List<?> defaultParameters) {
    List<Class<?>> defaultParameterTypes = Lists.newArrayList();
    for (Object defaultParameter : defaultParameters) {
      defaultParameterTypes.add(defaultParameter.getClass());
    }
    return defaultParameterTypes;
  }

  public Optional<? extends K> interpret(String command)
      throws InterpreterException {
    if (command == null || command.trim().isEmpty()) {
      return null;
    }

    Scanner scanner = new Scanner(command);
    String commandName = scanner.next();

    /* get default parameters and default parameter types for command */
    List<Class<?>> parameterTypes = Lists
        .newArrayList(getDefaultParameterTypesForCommand(commandName));
    List<Object> parameters = Lists
        .newArrayList(getDefaultParametersForCommand(commandName));

    /* if command given has parameters, get the parameters in the command string */
    if (scanner.hasNext()) {
      List<ParameterType> paramTypes = commandParamTypeMap.get(commandName);
      if (paramTypes != null) {
        Pair<List<Class<?>>, List<?>> commandParameters = getParametersForArgument(
            scanner, paramTypes);
        parameters.addAll(commandParameters.getValue1());
        parameterTypes.addAll(commandParameters.getValue0());
      }
    }

    /* get the command class for the given command name so we can instantiate it. */
    Class<? extends K> resultClass = commandResultClassMap.get(commandName);
    if (resultClass == null) {
      return Optional.absent();
    }

    /* instantiate class by using constructors */
    try {
      Constructor<? extends K> constructor = resultClass
          .getConstructor(parameterTypes.toArray(new Class<?>[parameterTypes
              .size()]));

      return Optional.of(constructor.newInstance(parameters
          .toArray(new Object[parameters.size()])));
    } catch (Throwable e) {
      throw new InterpreterException(e);
    } finally {
      scanner.close();
    }
  }

  private Pair<List<Class<?>>, List<?>> getParametersForArgument(
      Scanner scanner, List<ParameterType> paramTypes) {
    List<Object> parameters = Lists.newArrayList();
    List<Class<?>> parameterTypes = Lists.newArrayList();

    for (ParameterType paramType : paramTypes) {
      if (paramType == ParameterType.INT && scanner.hasNextInt()) {
        parameters.add(new Integer(scanner.nextInt()));
        parameterTypes.add(Integer.class);
      } else if (paramType == ParameterType.SHORT && scanner.hasNextShort()) {
        parameters.add(new Short(scanner.nextShort()));
        parameterTypes.add(Short.class);
      } else if (paramType == ParameterType.BYTE && scanner.hasNextByte()) {
        parameters.add(new Byte(scanner.nextByte()));
        parameterTypes.add(Byte.class);
      } else if (paramType == ParameterType.BOOL && scanner.hasNextBoolean()) {
        parameters.add(new Boolean(scanner.nextBoolean()));
        parameterTypes.add(Boolean.class);
      } else {
        break;
      }
    }

    return new Pair<List<Class<?>>, List<?>>(parameterTypes, parameters);
  }

  private List<?> getDefaultParametersForCommand(String commandName) {
    List<?> defaultParameters = commandDefaultParameters.get(commandName);
    return defaultParameters == null ? Collections.<Object> emptyList()
        : defaultParameters;
  }

  private List<Class<?>> getDefaultParameterTypesForCommand(String commandName) {
    List<Class<?>> defaultParameterTypes = commandDefaultParameterTypes
        .get(commandName);
    return defaultParameterTypes == null ? Collections.<Class<?>> emptyList()
        : defaultParameterTypes;
  }
}

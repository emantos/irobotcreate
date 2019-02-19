package com.kapre.irobot.shell;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kapre.irobot.shell.CommandInterpreter.ParameterType;

public class CommandInterpreterBuilder<K> {

  private final Map<String, ParameterType> commandParameterTypes = Maps.newLinkedHashMap();
  {
    commandParameterTypes.put("<i>", ParameterType.INT);
    commandParameterTypes.put("<s>", ParameterType.SHORT);
    commandParameterTypes.put("<b>", ParameterType.BYTE);
    commandParameterTypes.put("<f>", ParameterType.BOOL);
  }

  private Map<String, List<ParameterType>> commandParamTypeMap = Maps.newLinkedHashMap();
  private Map<String, Class<? extends K>> commandResultClassMap = Maps.newLinkedHashMap();
  private Map<String, List<?>> commandDefaultParameters = Maps.newLinkedHashMap();
  private Map<String, List<Class<?>>> commandDefaultParameterTypes = Maps.newLinkedHashMap();

  public CommandInterpreterBuilder<K> add(String commandName, String parameter, Class<? extends K> result) {
    return add(commandName, parameter, result, Collections.emptyList());
  }

  public CommandInterpreterBuilder<K> add(String commandName, String parameter, Class<? extends K> result,
      List<?> defaultParameters) {
    if (commandName == null || commandName.trim().isEmpty()) {
      throw new IllegalArgumentException("commandName is null or empty");
    }

    if (result == null) {
      throw new IllegalArgumentException("result is null");
    }

    commandResultClassMap.put(commandName, result);
    commandParamTypeMap.put(commandName, getParameterTypes(parameter));
    commandDefaultParameters.put(commandName, defaultParameters);
    commandDefaultParameterTypes.put(commandName, getDefaultParameterTypes(defaultParameters));

    return this;
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

  public CommandInterpreter<K> build() {
    return new CommandInterpreter<K>(commandParamTypeMap, commandResultClassMap, commandDefaultParameters,
        commandDefaultParameterTypes);
  }
}

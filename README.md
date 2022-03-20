# CloverPluginUtilities
A library for spigot plugin development

This library adds some features to help you out with creating spigot-plugins.

The following features are currently intended:
- MathUtils: Math helper for certain tasks
- Backend: Backend interfaces and implementations for YamlFiles etc
- Cooldown: Cooldown-manager class i.e. for kit-cooldowns
- GUIs: A GUI-package with several classes that help you to easily create GUIs and have events etc registered. Also a paged-GUI type is supported
- RecipeBuilder: Builder-classes for crafting- and villagers-recipes

## Maven implementation

![Release](https://jitpack.io/v/KleeSup/CloverPluginUtilities.svg)
Add the following repository:
```
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
then add the dependency
```
<dependency>
    <groupId>com.github.KleeSup</groupId>
    <artifactId>CloverPluginUtilities</artifactId>
    <version>version</version>
</dependency>
```

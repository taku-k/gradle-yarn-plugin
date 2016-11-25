# Gradle Plugin for Yarn :package::cat2:

[![Build Status](https://travis-ci.org/taku-k/gradle-yarn-plugin.svg?branch=master)](https://travis-ci.org/taku-k/gradle-yarn-plugin)
[![Coverage Status](https://coveralls.io/repos/github/taku-k/gradle-yarn-plugin/badge.svg)](https://coveralls.io/github/taku-k/gradle-yarn-plugin)

You can run any [Yarn](https://yarnpkg.com) commands in your gradle scripts by using this plugin.
This plugin downloads any version of [Yarn](https://yarnpkg.com)
into your `.gradle` directory and you can use them from there.

## Installation

Releases of this plugin are hosted at [Gradle Plugin Portal](https://plugins.gradle.org/plugin/me.taku_k.yarn).

If you use Gradle > 2.1, setup the plugin like this:

```
plugins {
  id "me.taku_k.yarn" version "0.1.1"
}
```

Otherwise:

```
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.me.taku_k.gradle.yarn:gradle-yarn-plugin:0.1.1"
  }
}

apply plugin: "me.taku_k.yarn"
```


## `yarn` Tasks Execution

### `yarnSetup` task

This task downloads a custom version of `yarn` script from
[GitHub - Yarn](https://github.com/yarnpkg/yarn/releases).
The directory where the script is saved is under the `.gradle/yarn` in default setting.

### `yarnInstall` task

This task installs packages that `package.json` depends on.

## `yarn` Extension Configuration

If you would like to use a specified version of `yarn`,
"yarn" extension block is like this:

```
yarn {
	version = '0.17.9'
}
```

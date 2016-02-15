[![Build Status](https://travis-ci.org/OrbitalEnterprises/orbital-eve-xml-api.svg?branch=master)](https://travis-ci.org/OrbitalEnterprises/orbital-eve-xml-api)
[![codecov.io](https://codecov.io/github/OrbitalEnterprises/orbital-eve-xml-api/coverage.svg?branch=master)](https://codecov.io/github/OrbitalEnterprises/orbital-eve-xml-api?branch=master)

# EVE XML API library

This module provides a library for interacting with the EVE XML API servers.
The current version of this code is a cleaned up and reworked early fork of
[EveApi](https://github.com/ZyorTaelon/eveapi).  A less cleaned up version of
this code was also used in EveKit.

## Build

### Maven

We use [Maven](http://maven.apache.org) to build EVE XML API, and publish to [Maven Central](http://search.maven.org/).
The easiest way to use EVE XML API is to add the following dependency to your pom.xml:

```xml
<dependency>
    <groupId>enterprises.orbital</groupId>
    <artifactId>eve-xml-api</artifactId>
    <version>1.0.0</version>
</dependency>
```

You can find more details about the artifact [here](http://mvnrepository.com/artifact/enterprises.orbital/eve-xml-api).

### Non-Maven

EVE XML API has the following dependencies which you'll need to build and run properly:

* [Orbital license v1.0.0](https://github.com/OrbitalEnterprises/license)
* [Orbital base v1.0.0](https://github.com/OrbitalEnterprises/base)
* [Apache commons-digester 2.1](https://commons.apache.org/proper/commons-digester/)
* [Apache httpclient 4.5.1](http://hc.apache.org/httpcomponents-client-4.5.x/index.html)

If you want to run unit tests, you'll also need:

* [xmlunit 1.3](http://sourceforge.net/projects/xmlunit/)
* [Apache commons-lang3 3.4](http://commons.apache.org/proper/commons-lang/)

## Usage

The EVE XML API library is divided into separate API (all packages in ```enterprises.orbital.evexmlapi```)
and implementation (all packages in ```enterprises.orbital.impl.evexmlapi```) sections. 
The library can be used entirely by referencing the API.  You need not reference the implementation unless
you want to make changes or additions.

The library is used by creating a "handle" which can then be used to issue any API call.  The following
example displays current server status:

```java
IEveXmlApi apiHandle = new EveXmlApiAdapter();
IServerAPI serverAPIHandle = apiHandle.getServerAPIService();
IServerStatus status = serverAPIHandle.requestServerStatus();
if (!serverAPIHandle.isError()) {
  if (status.isServerOpen()) {
    System.out.println("EVE is online with " + status.getOnlinePlayers() + " players.");
  } else {
    System.out.println("EVE is offline.");
  }
}
```

The handle can be customized by passing an instance of ```EveXmlApiConfig```.  This class allows the customization of
several important properties such as the server URL, the "User-Agent" for connections, and connection
timeout properties.  For example, to specify an agent string:

```java
IEveXmlApi apiHandle = new EveXmlApiAdapter(EveXmlApiConfig.get().agent("EveXmlApi/1.0.0 (https://github.com/OrbitalEnterprises/eve-xml-api; you@somewhere.com; )"));
...
```

Each API handle is independent, meaning you can instantiate multiple handles if you need different connection
properties for different requests.  You'll also need to instantiate separate handles if you need to make
concurrent requests as a single handle is intended to be used in serial fashion (see below).

Some calls will require authentication information (e.g. keyID, vCode and character ID).  This information is
passed when the handle is created for an API section which requires this information.  For example:

```java
int keyID = ...;
String vCode = ...;
long characterID = ...;
IEveXmlApi apiHandle = new EveXmlApiAdapter();
ICharacterAPI charAPIHandle = apiHandle.getCharacterAPIService(keyID, vCode, characterID);
ICharacterSheet sheet = charAPIHandle.requestCharacterSheet();
...
```

Some API sections do not require credentials except for a small number of requests (e.g. EVE API section).
For these sections, credentials can be passed on the individual request.

### Error Handling

API calls can fail in one of two ways:

1. By throwing an ```IOException```; or
2. By returning an error code and message.

An ```IOException``` is thrown for basic connectivity errors or other errors which prevent receiving a proper
response from the server.  An error status is set if an EVE XML endpoint error response is received.
When an error response is received, the API will return ```null``` and set appropriate error fields on the API
object.  The first example above shows the expected pattern for detecting error responses before processing
data.

Note that since error information is stored in the API handle, a handle can not be used for concurrent requests.
If you need to make concurrent requests, you'll need to instantiate multiple handles.  For example:

```java
IEveXmlApi apiHandle = new EveXmlApiAdapter();
IServerAPI firstServerAPIHandle = apiHandle.getServerAPIService();
IServerAPI secondServerAPIHandle = apiHandle.getServerAPIService();
// firstServerAPIHandle and secondServerAPIHandle can be used concurrently.
...
```

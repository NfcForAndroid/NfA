# Nfa : Nfc For Android

## Overview
NfA is a group of nfc helper for *android* platform.

The main purpose is to facilitate the creation /  communication with nfc devices in the android platform.

## Main features

The main features are : 

* NFC-Forum standards record implementations. You won't have to manage byte array ! You will deal with POJO
* Parsers for thoses implementations
* Writers for thoses implementations
* Filters for thoses implementations
* Somes useful constantes likes URI prefix / intent filters action / ...	


## Description of modules

The librairie is devided into maven modules in order to only offer to developper the code he needs.

With this library, you can easly do : 
* Read the content of a tag
* Write on tag
* Use the snep protocol (Beam on android)
* Transfert multiples record per ndefMessage

### nfa-all : 
This module reference all the others module, it is use for generating a single jar

Maven dependency
```xml
	<dependency>
		<groupId>com.github.nfcforandroid</groupId>
		<artifactId>nfa-api</artifactId>
		<version>0.7.0-SNAPSHOT</version>
	</dependency>
```

### nfa-api : 
In this module is defined all the interface and the apis that are exposed with NfA

Maven dependency
```xml
	<dependency>
		<groupId>com.github.nfcforandroid</groupId>
		<artifactId>nfa-api</artifactId>
		<version>0.7.0-SNAPSHOT</version>
	</dependency>
```

### nfa-records ! 
In this module, you will find the records implementations of NFC-Forum standards. For the moment the manage records are : 
* Text
* Uri
* SmartPoster
* MimeType
* Ndef
* AndroidApplicationRecord
* WellKnownType
* UnknowType
* Unsupported type
* Empty
* External
* Text Extrenal record

Maven dependency
```xml
	<dependency>
		<groupId>com.github.nfcforandroid</groupId>
		<artifactId>nfa-records</artifactId>
		<version>0.7.0-SNAPSHOT</version>
	</dependency>
```

### nfa-writers
In this module, you will find the classes that will helps you to write thoses records. For the moment, here is the list of manage writers : 
* Text
* Uri
* SmartPoster
* MimeType
* Ndef
* AndroidApplicationRecord
* WellKnownType
* UnknowType
* Unsupported type
* Empty

Maven dependency
```xml
	<dependency>
		<groupId>com.github.nfcforandroid</groupId>
		<artifactId>nfa-writers</artifactId>
		<version>0.7.0-SNAPSHOT</version>
	</dependency>
```

### nfa-parsers
In this module, you will find the classes that will helps you to reads the records. For the moment, here is the list of manage parsers : 
* Text
* Uri
* SmartPoster
* MimeType
* Ndef
* WellKnownType
* UnknowType
* Unsupported type
* Empty
* External
* Text External record

Maven dependency
```xml
	<dependency>
		<groupId>com.github.nfcforandroid</groupId>
		<artifactId>nfa-parsers</artifactId>
		<version>0.7.0-SNAPSHOT</version>
	</dependency>
```

### nfa-filters
In this module, you will find the classes that will helps you to define intent filters for your application. Here is the list of manage filters : 
* Ndef discover
* Tag discover
* Tech discover
* Text (text/plain)
* Uri (http://)
* External
* Text External

Maven dependency
```xml
	<dependency>
		<groupId>com.github.nfcforandroid</groupId>
		<artifactId>nfa-filters</artifactId>
		<version>0.7.0-SNAPSHOT</version>
	</dependency>
```

### nfa-core
This module contains an implementation of the api module in order to minimize the code needed to. The module contains a *NFA_MANAGER* that is an equivalent of the NfcAdapter but which provides you other method for working with tags.

Maven dependency
```xml
	<dependency>
		<groupId>com.github.nfcforandroid</groupId>
		<artifactId>nfa-core</artifactId>
		<version>0.7.0-SNAPSHOT</version>
	</dependency>
```

### nfa-apklib
This module offers you some constants that you could use in the manifest or in your android code. In the future version, somes Abstract activities will be present.

Maven dependency
```xml
	<dependency>
		<groupId>com.github.nfcforandroid</groupId>
		<artifactId>nfa-apklib</artifactId>
		<version>0.7.0-SNAPSHOT</version>
	</dependency>
```

### nfa-samples
This module is a demo application that present you some of the possibilities of the librairies and helps you to understand how to implement it.

## How to use it ?

See the [wiki pages](https://github.com/NfcForAndroid/NfA/wiki) for the developpers installation

## In the road map

Here is the list the next plained features : 
* 0.8.0
 * Have for each record : a writer / parser / filter
 * Add Signature Record
 * Add the possibility for smartPoster to have more than a title
 * Add junit tests
* 0.9.0
 * Add Handover records
 * Add Crypto module for an easier management of data to transfert
 * Add Abstract Activities for an easer management of methods link to the life cycle
* 1.0.0
 * Optimize the code
 * bug fix


## Source of inspiration

Hudge Thank you to thoses projects who helps me to start NfA : 

* [RoboSpice](https://github.com/octo-online/robospice) for the maven structure
* [NfcTools](https://github.com/grundid/nfctools) and [Ndef tools for Android](http://code.google.com/p/ndef-tools-for-android/) for the existants records.

## License

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	     http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
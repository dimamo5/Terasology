# Software Testing

##Index

1. [**Degree of testability**](#Degree)
	* [Controllability](#Controllability)
	* [Observability](#Observability)
	* [Isolateability](#Isolateability)
	* [Separation of concerns](#Separation)
	* [Understandability](#Understandability)
	* [Heterogeneity](#Heterogeneity)
2. [**Test Statistics**](#Stats)

<a name="Degree"/>
## Degree of testability

**Terasology** is a very complex project which means that the degree of testability is not easily concluded. The following topics analize the program in every aspect of testability in order to understand whether the software can be tested in a correct way or not.

The testability of software components (modules) can be determined by many factors such as:

1. **Controllability**: The degree to which it is possible to control the state of the component under test (CUT) as required for testing.
2. **Observability**: The degree to which it is possible to observe (intermediate and final) test results.
3. **Isolateability**: The degree to which the component under test (CUT) can be tested in isolation.
4. **Separation of concerns**: The degree to which the component under test has a single, well defined responsibility.
5. **Understandability**: The degree to which the component under test is documented or self-explaining.
6. **Heterogeneity**: The degree to which the use of diverse technologies requires to use diverse test methods and tools in parallel.

<a name="Controllability"/>
###Controllability

**Controllability** is related to the degree to which the **Component Under Test** has a single, well defined responsibility. 
All software components are part of a module that can be connected to a lot of other modules. Controllability is defined as the effort it takes to provide 
a program with the needed inputs, in terms of values, operations and behaviors. As mentioned in the [forum] (http://forum.terasology.org/threads/development-methodology-and-hi-students-from-porto.1387/) if we take a look into 
engine module, which is associated with a lot of other modules, controllability tends to be low because it is harder to 
provide the system with tests for all possible situations in different cases. However when testing an isolated component, controllability must be higher 
because the environment in which the test will run is going to be much smaller and controlable. Its interaction is limited to engine itself or
components form other modules or even components external to Terasology. It all dependes on the situation. In embedded modules or modules that depend from 
others controllability tends to be low. 
Testing components from modules or even the deepest engine modules can lead to a higher controlability rather than testing the engine itself. 

<a name="Observability"/>
###Observability

**Observability** is related to the degree to which it is possible to observe (intermediate and final) test results. 
In Terasology as they mention in the [forum] (http://forum.terasology.org/threads/development-methodology-and-hi-students-from-porto.1387/) they use Jenkins to generate test code automatically which is written in JUnit. 
Jenkins is executed every time there is a single engine build or pull requests submitted to GitHub in order to prevent messing with everything done so far.
[Here] (http://jenkins.terasology.org/job/Terasology/) we can find the JUnit test results and in the [statistics webpage] (http://jenkins.terasology.org/view/Statistics/)
 we can find not just the results but also metrics across a large amount of code, such as quantity and coverage. Althout the same metrics are available for all modules they're not always active or appropriate. 
Other modules just don't have any unit tests because the author hasn't added any.
 
 Beyond unit tests they have several other code metrics  - in order of appearance in Jenkins:
 #Metrics
* Checkstyle: scans our code style / conventions to make sure the code is consistently using the same style everywhere
* FindBugs: scans for some common code drawbacks that can easily lead to bugs
* PMD: more of the same - style, common issues, etc
* Open Tasks: simply looks for TODO tags in the code indicating something needs to be done
* Static analysis: aggregate of the above (all them of added together)
* Code coverage: how many lines of code are actually exercised by the unit tests

<a name="Isolateability"/>
###Isolateability

**Isolateability** is related to the degree to which the component under test (CUT) can be tested in isolation.
Once modules aren't independent from each other it is hard to separate Isolateability from Controllability, what we are trying to say
 is that a lot of the component's behaviour is related to how it interacts with the rest of the system. For example depending on how the component interacts with 
 the rest of the modules and even with other components the test can be right or wrong without necessarily being right or wrong. 
So it wouldn't make sense to calculate the Isolateability’s degree for Terasology because it is dificult to understand 
in which situations it would make sense to test the component isolated from the rest.

<a name="Separation"/>
### Separation of concerns

>In computer science, separation of concerns (SoC) is a design principle for separating a computer program into distinct sections,    such that each section addresses a separate concern.
>  - found on Wikipedia

**Terasology** is organized in several high level modules (the most complex) as it was refered in the previous report. These modules handle different tasks and, inside of them, the task is divided between various subunits. For example, [the engine module calls the Context which divides in many other processes that take care of the graphic aspects of the game](https://github.com/dimamo5/Terasology/blob/develop/ESOF-DOCS/Software%20Architecture.md). This way, it is logical to say that the present project has a successful separation of concerns. 

In our opinion, this separation turns out to be very efficient since it scatters the responsability through different units which can lead to a better performance and increases the degree of testability of each unit. There is always room for improvement but the current separation permits a high level of testability.

<a name="Understandability"/>
### Understandability

Understandability is a contorversial theme for testability. In fact, it is a gruelling task to classify the understandability of software since this aspect is different for each individual. As many authors point out, the degree of understandability is also affected by the used language. It is safe to say that the language used in the project (Java) is a clear and straight forward one which contributes to facilitate the contribution of the code.

About the concrete aspects, the project has many ways to communicate with external contribuitors. Besides the [forum](http://forum.terasology.org/) and the [issues tracking](https://github.com/MovingBlocks/Terasology/issues), the most important document to understand the code is the [wiki](https://github.com/MovingBlocks/Terasology/wiki) provided. Although there are many files thorougly explaning many aspects of the code, it may seem confusing and misleading for new members. The organization of the documents is very important to fight this problem. The leading developers are always available to discuss any doubts and to provide any support but the available documents are of the most importance in order to heighten the comprehension degree of the software. 

To sum up, it is safe to say that the program is well documented and its degree of understandability can be refered to as high. Although, it is imperative to organize the information and make it more accessible and less confusing.

<a name="Heterogeneity"/>
### Heterogeneity

Heterogeneity serves the purpose of revealing how many external resources are used in the project. In this aspect, **Terasology** can be considered a heterogeneous program since it uses a wide range of external technologies. In fact, in order to run the game, many libraries are needed. The list of dependencies can be consulted in the file that permits the compilation of the code. Libraries related to Java such as the LWJGL (refered in previous reports), Jinput and many others are the most popular and contribute by adding functionalities to the game. On the list there are some librarys developed specifically for the project such as **gestalt-module**, **gestalt-asset-core**, **TeraMath**, **tera-bullet** and **splash-screen**. The following are some of the used technologies:

1. **guava**, **netty**, **gson**
	* for purposes of networking and memory

2. **java3d**, **lwjgl_util**, **miglayout-core**, **PNGDecoder**
	* for graphics and others

3. **reflections**, **javassist**, **jna-platform**
	* for specific Java functionalities


The use of external technologies can rise to be problematic due to the fact that it is not very clear whether the librarys are completely trustworthy or not. The libraries available for Java are well known and popular but this does not guarantee that they are bulletproof. A test may fail due to a library and, in this case, it is hard to distinguish whether the mistake is in the tested code or the resources. The tests must be sensible to this problem.

To conclude, the project has a high level of heterogeneity. Although, it is relevant to refer that the use of external dependencies should be managed with great care and caution. Problems may arise due to the external dependencies which could be disastrous for the project for the error would be very hard to spot. 
<br>


<a name="Stats"/>
##Test Statistics

Terasology uses Jenkins platform with automated tests in order to evaluate code metrics for further analisys.
Jenkins builds Terasology via Gradle and runs several tests obtaining [various statistics](#Metrics)  that can be found on [Terasology's project page on Jenkins] (http://jenkins.terasology.org/view/Statistics/job/Terasology/). <br> Unit testing is writen in JUnit and follows a White-box desing, since the test cases are added as needed and are measured using Jenkins platform.

![Graph](https://github.com/dimamo5/Terasology/blob/sergio/ESOF-DOCS/images/graph.png)

The above graph represents the project's unit test code coverage in terms of line coverage / missing and can be seen in the page mentioned before. 

* Lines missed: ~40.000
* Lines covered: ~15.000

According to Jenkins the project as a 25.86% line coverage, moreover most of the project sections doesn't have any kind of unit testing wich reveals some fragility in terms of code reliability and a big limitation when it comes to integration testing and consequently validation testing. <br>Project Lead Cervator refers that there is a lack of testing in the project despite of being one of the project's present goals. [In this thread](http://forum.terasology.org/threads/the-world-of-varied-and-noteworthy-achievements.1209/) he writes about topics as "Automated acceptance testing", "Multiplayer testing", relative to what needs to be implemented in order to make testing easier. <br>

Since this is a contributor dependent project perhaps with the creation of more intuitive and efficient testing methods it would be possible to obtain higher volume of tests (also higher test quality) from contributors in order to make this project more stable in modular terms and would be easier to accept and integrate developed features thus increasing project's dynamic and cohesion.



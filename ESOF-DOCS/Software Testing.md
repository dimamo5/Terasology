# Software Testing

##Index


### Degree of testability

**Terasology** is a very complex project which means that the degree of testability is not easily concluded. The following topics analize the program in every aspect of testability in order to understand whether the software can be tested in a correct way or not.

### Separation of concerns

>In computer science, separation of concerns (SoC) is a design principle for separating a computer program into distinct sections,    such that each section addresses a separate concern.
>  - found on Wikipedia

**Terasology** is organized in several high level modules (the most complex) as it was refered in the previous report. These modules handle different tasks and, inside of them, the task is divided between various subunits. For example, [the engine module calls the Context which divides in many other processes that take care of the graphic aspects of the game](https://github.com/dimamo5/Terasology/blob/develop/ESOF-DOCS/Software%20Architecture.md). This way, it is logical to say that the present project has a successful separation of concerns. 

In our opinion, this separation is turns out to be very efficient since it scatters the responsability through different units which can lead to a better performance and increases the degree of testability of each unit. There is always room for improvement but the current separation permits a high level of testability.

### Understandability

Understandability is a contorversial theme for testability. In fact, it is a gruelling task to classify the understandability of software since this aspect is different for each individual. As many authors point out, the degree of understandability is also affected by the used language. It is safe to say that the language used in the project (Java) is a clear and straight forward one which contributes to facilitate the contribution of the code.

About the concrete aspects, the project has many ways to communicate with external contribuitors. Besides the [forum](http://forum.terasology.org/) and the [issues mechanism](https://github.com/MovingBlocks/Terasology/issues), the most important document to understand the code is the [wiki](https://github.com/MovingBlocks/Terasology/wiki) provided. Although there are many files thorougly explaning many aspects of the code, it may seem confusing and misleading for new members. The organization of the documents is very important to fight this problem. The leading developers are always available to discuss any doubts and to provide any support but the available documents are of the most importance in order to heighten the comprehension degree of the software. 

To sum up, it is safe to say that the program is well documented and its degree of understandability can be refered to as high. Although, it is imperative to organize the information and make it more accessible and less confusing.

### Heterogeneity

Heterogeneity serves the purpose of revealing how many external resources are used in the project. In this aspect, **Terasology** can be considered a heterogeneous program since it uses a wide range of external technologies. In fact, in order to run the game, many libraries are needed. The list of dependencies can be consulted in the file that permits the compilation of the code. Libraries related to Java such as the LWJGL (refered in previous reports), Jinput and many others are the most popular and contribute by adding functionalities to the game. On the list there are some librarys developed specifically for the project such as **gestalt-module**, **gestalt-asset-core**, **TeraMath**, **tera-bullet** and **splash-screen**. Some of the used technologies are the following:

1. **guava**, **netty**, **gson**
	* for purposes of networking and memory

2. **java3d**, **lwjgl_util**, **miglayout-core**, **PNGDecoder**
	* for graphics and others

3. **reflections**, **javassist**, **jna-platform**
	* for specific Java functionalities


The use of external technologies can rise to be problematic due to the fact that it is not very clear whether the librarys are completely trustworthy or not. The libraries available for Java are well known and popular but this does not guarantee that they are bulletproof. A test may fail due to a library and, in this case, it is hard to distinguish whether the mistake is in the tested code or the resources. The tests must be sensible to this problem.

To conclude, the project has a high level of heterogeneity. Although, it is relevant to refer that the use of external dependencies should be managed with great care and caution. Problems may arise due to the external dependencies which could be disastrous for the project for the error would be very hard to spot. 


##Test Statistics

Terasology use Jenkins platform with automated tests in order to evaluate code metrics for further analisys.
Jenkins builds Terasology via Gradle and runs several tests obtaining statistics relatively to coding style, TODO issues, "lead-to-bug-code", unit testing coverage and some other metrics, that can be found on [Terasology's project page on Jenkins] (http://jenkins.terasology.org/view/Statistics/job/Terasology/). <br> Unit testing is writen in JUnit and follows a White-box desing, since the test cases are added as needed and are measured using Jenkins platform.

![Graph](https://github.com/dimamo5/Terasology/blob/sergio/ESOF-DOCS/images/graph.png)

The above graph represents the project's unit test code coverage in terms of line coverage / missing and can be seen in the page mentioned before. 

* Lines missed: ~40.000
* Lines covered: ~15.000

According to Jenkins the project as a 25.86% line coverage, moreover most of the project sections doesn't have any kind of unit testing wich reveals some fragility in terms of code reliability and a big limitation when it comes to integration testing and consequently validation testing. <br>Project Lead Cervator refers that there is a lack of testing in the project despite of being one of the project's present goals. [In this thread](http://forum.terasology.org/threads/the-world-of-varied-and-noteworthy-achievements.1209/) hw writes about topics as "Automated acceptance testing", "Multiplayer testing", relative to what needs to be implemented in order to make testing easier. <br>

Since this is a contributor dependent project perhaps with the creation of more intuitive and efficient testing methods it would be possible to obtain higher volume of tests (also higher test quality) from contributors in order to make this project more stable in modular terms and would be easier to accept and integrate developed features thus increasing project's dynamic and cohesion.



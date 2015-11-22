##Test Statistics

Terasology use Jenkins platform with automated tests in order to evaluate code metrics for further analisys.
Jenkins builds Terasology via Gradle and runs several tests obtaining statistics relatively to coding style, TODO issues, "lead-to-bug-code", unit testing coverage and some other metrics, that can be found on [Terasology's project page on Jenkins] (http://jenkins.terasology.org/view/Statistics/job/Terasology/). <br> Unit testing is writen in JUnit and follows a White-box desing, since the test cases are added as needed and are measured using Jenkins platform.

![Graph](https://github.com/dimamo5/Terasology/new/sergio/ESOF-DOCS/images/graph.png)

The above graph represents the project's unit test code coverage in terms of line coverage / missing and can be seen in the page mentioned before. 

* Lines missed: ~40.000
* Lines covered: ~15.000

According to Jenkins the project as a 25.86% line coverage, moreover most of the project sections doesn't have any kind of unit testing wich reveals some fragility in terms of code reliability and a big limitation when it comes to integration testing and consequently validation testing. <br>Project Lead Cervator refers that there is a lack of testing in the project despite of being one of the project's present goals. [In this thread](http://forum.terasology.org/threads/the-world-of-varied-and-noteworthy-achievements.1209/) hw writes about topics as "Automated acceptance testing", "Multiplayer testing", relative to what needs to be implemented in order to make testing easier. <br>

Since this is a contributor dependent project perhaps with the creation of more intuitive and efficient testing methods it would be possible to obtain higher volume of tests from contributors in order to make this project more stable in modular terms and would be easier to accept and integrate developed features thus increasing project's dynamic and cohesion.



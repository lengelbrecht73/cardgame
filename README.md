# Cardgame

##Requirements
1. mvn
2. Java 17
3. Linux
<br/><br/>

## How to build and run
1. The project can be build by running the build.sh command:
<br/>
scripts/build.sh

2. The program is started by running the following command:
scripts/run.sh

Please note that the run.sh script will check if the target folder exists. If not, it will
run the build.sh command first.

## Some important notes
<br/>
1. The Fisher-Yates shuffling algorithm is currently implemented to shuffle the cards. The Collection
shuffle is also included, but not used. It is only for the purpose to replace the one with the other if
needed.
<br/>
2. Provision is made to easily add development for the Badugi version of the game. The ranking alogorithm
is mostly outstanding to implement this variant.
<br/>
3. To easily change from the console-based solution to a web based solution, the development was done using
the Spring Boot framework. To add a web frontend and / or REST API's the following dependency can be added and
used:
<br/>
	<dependency>
        	<groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
<br/>
4. For reporting on code coverage by test cases, the Jacoco plugin was added. Ajou te
report of test case coverage can be find in the target/site/jacoco folder. The
focus was on testing the logic and DealerService. The Baldugi ranking alogorithm and Collection shuffle
was not added to the test cases, as it is not required at the moment. The FiveCard ranking alogorithm as
well as the Fisher-Yates shuffle are covered.
<br/>
<br/>
Enjoy the game. 




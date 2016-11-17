# Continuous Integration Presentation
A presentation on continous integration using Jenkins and Artifactory.

## Prerequisites
1. [Docker](https://docs.docker.com/engine/installation)
2. [mpd](https://github.com/visit1985/mdp) - if you want to look at slides

## Getting Started
1. Install Docker
2. Run the following commands in the Docker Terminal:

```
docker pull docker.bintray.io/jfrog/artifactory-oss
docker pull jenkins
```

## Using this project for the demonstration
1. This project is designed to be used for the CI demonstration instructed in this README.
2. Please clone/fork to use this project for that reason.
3. Have fun!

## Setup Jenkins and Artifactory
1. Clone this repository.
2. Install Docker.
3. Open up Docker terminal.
4. Run `docker-machine ip default` and remember that IP. The IP will be referenced in this README as `<docker-ip>`. NOTE: if you are a OSX user you will not have to run this command - `<docker-ip>` will be `localhost` for those users.
5. Run `docker run -d --name artifactory -p 8082:8081 docker.bintray.io/jfrog/artifactory-oss`
5. Run `docker run -p 8080:8080 -p 50000:50000 --name jenkins -d jenkins`
6. Goto `<docker-ip>:8080` to start the Jenkins setup.
7. Run `docker exec -it jenkins cat /var/jenkins_home/secrets/initialAdminPassword` to get the `admin password`.
8. Use the `admin password` in the browser and click `continue`.
9. Click `Install suggested plugins`.
10. Proceed with the rest of the Jenkins setup through the browser.
11. Install `Html Publisher Plugin` from `Jenkins home page` > `Manage Jenkins` > `Manage Plugins` > `Available Tab`.
12. Filter for the `Html Publisher Plugin`and check the check box next to the plugins and click `Install without restart`.

Jenkins will be running on `<docker-ip>:8080` and Artifactory on `<docker-ip>:8082`.

Note: Artifactory Admin username and password are `admin` and `password` respectively.

## Configure Jenkins Project
1. From `Jenkins Home Page` click on `New Item`.
2. Give the project a name, select `Freestyle Project` and click `Ok`.
3. Take this project and fork or clone it.
3. For `Source Code Management` select `git`, add the `Repository URL`, `Credentials` and branch to `dev`.
4. Under `Build Triggers` select `Poll SCM` and enter `H/5 * * * *`.
5. Under `Build` click `Add build step` and add `Invoke Gradle script`.
6. Select `Use Gradle Wrapper`, check mark `Make gradlew executable` and `From Root Build Script Dir`.
7. In the `Tasks` box add the following: `clean`, `test`, `jar` and `publish` in that order.
8. Under `Post-build Actions` click `Add post-build action` and select `Publish HTML reports`.
9. In the `HTML directory to archive` add `build/reports/tests/test`.
10. In the `Index page[s]` add `index.html`.
11. In the `Report title` add `Test Cases Report`.

## Running the project
The Jenkins project will check every 5 mins on the `dev` branch and see if there was any changes.
This can be executed by making changes to this project or clicking `Build Now` for the Jenkins Project.
If so, it will build and test the project.
You can add classes in `src/main/java` and/or junit test cases in `src/main/test` to see how this works.
If the tests passes it will publish the jar to Artifactory which you will see in the `Artifactory Repository Browser`.

## Setup Team City - if you want to, this is not completed
1. Run `docker run --name postgres -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres` to start the postgresql server.
2. Run `docker run -it --name teamcity -p 8111:8111 -d jetbrains/teamcity-server` to start the team city server.
3. Run `docker-machine ip default` and remember that IP. The IP will be referenced in this README as `<docker-ip>`. NOTE: if you are a OSX user you will not have to run this command - `<docker-ip>` will be `localhost` for those users.
4. Goto `<docker-ip>:8111` in a browser.
5. Click `Proceed` on the first page.
6. In `Select the database type` select `postgres`
7. Run `docker cp files/postgresql-9.4.1212.jar teamcity:/data/teamcity_server/datadir/lib/jdbc`.
8. Click `Refresh JDBC drivers` on the page
9. When setting up the database use `<docker-ip>` as the host, `postgres` as the user and `password` as the password. Omit the database name.
10. Follow the prompts to setup Team City in the browser.
11. Run `docker run -it -e SERVER_URL="192.168.99.100:8111" -e AGENT_NAME="default" --name teamcity-agent -d jetbrains/teamcity-minimal-agent` to install a Team City agent
12. In Team City click on `Agents` then `Unauthorized`.
13. Authorize the `default` agent.
14. Team City should now be running on `<docker-ip>:8111`.

## How to look at the slides
1. Clone this repository.
2. Goto the `slides` directory.
3. Run `mdp <slide.md>` (after mdp was installed) or you can just look at the `<slide.md>` if you are okay with reading markdown.

## Todo
- [x] Enviroment setup instructions
- [x] Simple Java project with tests
- [x] Make change to Java project - fires off Jenkins/Team City build
- [x] Creates build in Artifactory

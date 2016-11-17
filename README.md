# Artifactory Presentation
A presentation on Artifactory and all of the pieces that go into it.

## Prerequisites
1. [Docker](https://docs.docker.com/engine/installation)
2. [mpd](https://github.com/visit1985/mdp) - if you want to look at slides

## Setup
1. Clone this repository.
2. Install Docker.
3. Open up Docker terminal.
4. Run `docker-machine ip default` and remember that IP. The IP will be referenced in this README as `<docker-ip>`
5. Run `docker run -d --name artifactory -p 8082:8081 docker.bintray.io/jfrog/artifactory-oss`
5. Run `docker run -p 8080:8080 -p 50000:50000 --name jenkins -d jenkins`
6. Goto `<docker-ip>:8080` to start the Jenkins setup.
7. Run `docker exec -it jenkins cat /var/jenkins_home/secrets/initialAdminPassword` to get the `admin password`.
8. Use the `admin password` in the browser and click `continue`.
9. Click `Install suggested plugins`.
10. Proceed with the rest of the Jenkins setup through the browser.
11. Install `Html Publisher Plugin` from `Jenkins home page` > `Manage Jenkins` > `Manage Plugins` > `Available Tab`.
12. Filter for the `Html Publisher Plugin`and check the checkbox next to the plugins and click `Install without restart`.

Jenkins will be running on `<docker-ip>:8080` and Artifactory on `<docker-ip>:8082`.

Note: Artifactory Admin username and password are `admin` and `password` respectively.

## How to look at the slides
1. Clone this repository
2. Goto the `slides` directory
3. Run `mdp <slide.md>` (after mdp was installed) or you can just look at the `<slide.md>` if you are okay with reading markdown.

## How to run Team City in docker (never got this to work completely)
1. Run `docker run --name postgres -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres` to start the postgresql server.
2. Run `docker run -it --name teamcity -p 8111:8111 -d jetbrains/teamcity-server` to start the team city server.
3. Run `docker-machine ip default` and remember that IP. The IP will be referenced in this README as `<docker-ip>`
4. Goto `<docker-ip>:8111` in a browser.
5. Click `Proceed` on the first page
6. In `Select the database type` select `postgres`
7. Run `docker cp files/postgresql-9.4.1212.jar teamcity:/data/teamcity_server/datadir/lib/jdbc`.
8. Click `Refresh JDBC drivers` on the page
9. When setting up the database use `<docker-ip>` as the host, `postgres` as the user and `password` as the password. Omit the database name.
10. Follow the prompts to setup Team City in the browser.
11. Run `docker run -it -e SERVER_URL="192.168.99.100:8111" -e AGENT_NAME="default" --name teamcity-agent -d jetbrains/teamcity-minimal-agent` to install a Team City agent
12. In Team City click on `Agents` then `Unauthorized`.
13. Authorize the `default` agent.
14. Team City should now be running on `<docker-ip>:8111`

## Todo
- [x] Enviroment setup instructions
- [x] Simple Java project with tests
- [ ] Make change to Java project - fires off Team City build
- [ ] Creates build in Artifactory
- [ ] Reference Artifactory build in another Java project

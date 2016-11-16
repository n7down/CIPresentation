# Artifactory Presentation
A presentation on Artifactory and all of the pieces that go into it.

## Prerequisites
1. [Docker](https://docs.docker.com/engine/installation)
2. [mpd](https://github.com/visit1985/mdp) - if you want to look at slides

## Setup
1. Clone this repository.
2. Install Docker.
3. Open up Docker terminal.
4. Run `docker run --name postgres -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres` to start the postgresql server.
5. Run `docker run -it --name teamcity -p 8111:8111 -d jetbrains/teamcity-server` to start the team city server.
7. Run `docker-machine ip default` and remember that IP. The IP will be referenced in this README as `<docker-ip>`
8. Goto `<docker-ip>:8111` in a browser.
9. Click `Proceed` on the first page
10. In `Select the database type` select `postgres`
11. Run `docker cp files/postgresql-9.4.1212.jar teamcity:/data/teamcity_server/datadir/lib/jdbc`.
12. Click `Refresh JDBC drivers` on the page
13. When setting up the database use `<docker-ip>` as the host, `postgres` as the user and `password` as the password. Omit the database name.
14. Follow the prompts to setup Team City in the browser.
15. Run `docker run -it -e SERVER_URL="192.168.99.100:8111" -e AGENT_NAME="default" --name teamcity-agent -d jetbrains/teamcity-minimal-agent` to install a Team City agent
16. In Team City click on `Agents` then `Unauthorized`.
17. Authorize the `default` agent.
18. Run `docker run --name artifactory -p 8112:8081 -d docker.bintray.io/jfrog/artifactory-oss` to start the Artifactory server.

19. Run `docker run -p 8080:8080 -p 50000:50000 --name jenkins -d jenkins`
21. Goto `<docker-ip>:8080`.
20. Run `docker exec -it jenkins cat /var/jenkins_home/secrets/initialAdminPassword` to get the `admin password`.
22. Use the `admin password` in the browser and click `continue`.
23. Click `Install suggested plugins`.
24. Proceed with the rest of the Jenkins setup through the browser.

25. Install `Html Publisher Plugin`.

Team City should now be running on `<docker-ip>:8111` and Artifactory on `<docker-ip>:8112`.

Note: Artifactory Admin username and password are `admin` and `password` respectively.

## How to look at the slides
1. Clone this repository
2. Goto the `slides` directory
3. Run `mdp <slide.md>` (after mdp was installed) or you can just look at the `<slide.md>` if you are okay with reading markdown.

## Todo
- [x] Enviroment setup instructions
- [x] Simple Java project with tests
- [ ] Make change to Java project - fires off Team City build
- [ ] Creates build in Artifactory
- [ ] Reference Artifactory build in another Java project

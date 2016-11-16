# Artifactory Presentation
A presentation on Artifactory and all of the pieces that go into it.

## Prerequisites
1. [Docker](https://docs.docker.com/engine/installation)
2. [mpd](https://github.com/visit1985/mdp) - if you want to look at slides

## Setup
1. Clone this repository.
2. Install Docker.
3. Open up Docker terminal.
4. Run `docker run --name postgres -e POSTGRES_PASSWORD=password -d postgres` to start the postgresql server.
5. Run `docker run -it --name teamcity -p 8111:8111 -d jetbrains/teamcity-server` to start the team city server.
6. Run `docker cp files/postgresql-9.4.1212.jar teamcity:/data/teamcity_server/datadir/lib/jdbc`.
7. Run `docker-machine ip default` and remember that IP. The IP will be referenced in this README as `<docker-ip>`
8. Goto `<docker-ip>:8111` in a browser.
9. Follow the prompts to setup Team City. Please note when setting up the database use `<docker-ip>` as the host, `postgres` as the user and `password` as the password. Omit the database name.
10. Run `docker run --name artifactory -p 8112:8081 -d docker.bintray.io/jfrog/artifactory-oss` to start the artifactory server.

Team City should now be running on `<docker-ip>:8111` and Artifactory on `<docker-ip>:8112`.

## How to look at the slides
1. Clone this repository
2. Goto the `slides` directory
3. Run `mdp <slide.md>` (after mdp was installed) or you can just look at the `<slide.md>` if you are okay with reading markdown.

## Todo
- [x] Enviroment setup instructions
- [ ] Simple Java project with tests
- [ ] Make change to Java project - fires off Team City build
- [ ] Creates build in Artifactory
- [ ] Reference Artifactory build in another Java project

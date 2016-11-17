%title: Artifactory Presentation
%author: Joshua Adams
%date: 2016-11-18

-> Arifactory <-
=========

-> A Binary Repository Manager <-




-> ## What is a Binary Repository Manager? <-



-> A Binary Repository Manager is a software tool designed <-

-> to optimize the download and storage of binary files (Artifacts) <-

-> used and produced in software development. <-


-> A Binary Repository Manager also contains different package managers. <-

-> For example: NPM, Docker, NuGet, etc <-

-------------------------------------------------

-> Binary Repository Manager Products <-
=========


-> ## List of some Binary Repository Manager Products: <-



-> Apache Archiva <-

-> Jfrog's Artifactory <-

-> Inedo's ProGet <-

-> Sonatype Nexus <-




-> ## You may have used a Binary Respository Manager with out realizing it <-

-> Here is a Binary Respository Manager in action: <-

-> https://ftp.mozilla.org/pub/firefox/ <-




-> ## For a comparison of Binary Repository Managers go here: <-

-> https://binary-repositories-comparison.github.io <-

-------------------------------------------------

-> Continuous Delivery Pipeline <-
=========







-> Source Control (Github/Gitlab) <-


-> V <-


-> Build Server (Jenkins/Team City) <-


-> V <-


-> Binary Repository Manager (*Artifactory*/Proget) <-

-------------------------------------------------

-> Continuous Delivery Pipeline *In Detail*  <-
=========



-> Source Control <-



-> Two Branches <-




-> Development Branch <-

-> For the development of new features and bug fixes <-




-> Master Branch <-

-> For software that is live <-

-------------------------------------------------

-> Continuous Delivery Pipeline *In Detail*  <-
=========



-> Build Server <-



-> Two Projects <-




-> Development Project <-

-> Points to the development branch on source control <-

-> Builds nightly/development builds for testing as shown here: <-

-> https://nightly.mozilla.org/ <-





-> Production Project <-

-> Points to the master branch on source control and for live builds <-

-------------------------------------------------

-> Continuous Delivery Pipeline *In Detail*  <-
=========



-> Binary Repository Manager <-



-> Two Trees <-



-> Snapshot <-

-> Artifacts that are under development <-




-> Release <-

-> Artifacts that are live releases <-

-> Once these artifacts are in a Binary Repository Manager they can be then used via their Package Managers <-

-> For example: NuGet Artifacts (both development and releases)

-> can be used via NuGet Package Manager in Artifactory <-

-------------------------------------------------

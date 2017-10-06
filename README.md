### The Opendoor project [![Build Status](https://travis-ci.org/srininara/opendoor.svg?branch=master)](https://travis-ci.org/srininara/opendoor)

OpenDoor is your opportunity to provide feedback 24/7. Send an idea, constructive feedback or positive recognition at any time and you can choose whether it's anonymous or not. It's all captured in real-time and helps us to build stronger teams, improve the workplace and ensure that everyone has a voice within your organization.

### Instructions

* To build the project :  `./gradlew clean build`
* To start the application: `./gradlew startApp`
* To stop the application: `./gradlew stopApp`
* To deploy:
    * Ansible `2.4.0.0` is required
    * `cd deploy/ansible`
    * `ansible-playbook -i inventory/prod.ini playbook_deploy.yml -e 'tag=<TAG>' -vv`
    
* Sample URL for paging
    * localhost:8080/feedback
    * localhost:8080/feedback/?page=0&size=2

### Opendoor project! [![Build Status](https://travis-ci.org/srininara/opendoor.svg?branch=master)](https://travis-ci.org/srininara/opendoor)

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

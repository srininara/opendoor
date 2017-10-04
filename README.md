## Opendoor project!

=> Start DB:
`docker run -it -p 5432:5432 -v pgdata:/var/lib/postgresql/data --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres:alpine`
=> To build the project :  `./gradlew clean build`
=> To run the application: `./gradlew bootRun`
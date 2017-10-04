## Opendoor project!

1. To build the project :  `./gradlew clean build`
2. To run the application: `./gradlew bootRun`


3. Start DB:
`docker run -it -p 5432:5432 --rm -v pgdata:/var/lib/postgresql/data --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres`
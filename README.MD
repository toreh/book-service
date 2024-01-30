Commands
podman build  -f ./src/main/dockerBase/Dockerfile -t kbe-book-service .
podman run -p 8080:8080 -d kbe-book-service
podman ps

runs mySql via local profile 'localmysql'

JDBCtemplate mySql db:
- implements: get and getByAuthorId 

JPA mySql db:
- dependency problem: missing entityManagerFactory bean
- JPA clases moved to temp_files
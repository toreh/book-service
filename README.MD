Commands
podman build  -f ./src/main/dockerBase/Dockerfile -t kbe-book-service .
podman run -p 8080:8080 -d kbe-book-service
podman ps
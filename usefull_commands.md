```shell
podman container ps -a
podman ps -s #show size
podman build -t pedro-hos/app-node:1.3 .
podman run -p 9000:6000 -d localhost/pedro-hos/app-node:1.3
podman container rm $(podman container ls -aq)
podman rmi $(podman image ls -aq) --force
podman inspect <ID_CONTAINER>
```
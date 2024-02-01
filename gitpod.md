# Application installation guide on GitPod

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/Zeyad2003/Library-System-Crud)
> You may need this **[link](https://stackoverflow.com/questions/69669688/login-mysql-on-gitpod)** :)


1. Open the project in GitPod using the button above.

2. Create .gitpod.dockerfile with the following content
    ```docker
    FROM gitpod/workspace-mysql
    ```
   
3. Remove any content from .gitpod.yml and add the following:
    ```yml
    image:
      file: .gitpod.dockerfile
    ```
   

## GIT

1. #### 사전 준비

   - VS Code 설치(https://code.visualstudio.com/download)
   - 자신의 OS와 맞는 버전 설치

2. #### Git Bash

   - 작업하고자 하는 폴더에서 우클릭 후 git bash 실행

   - 최초 실행시 진행

     ```
     // git commit에 사용될 username
     git config --global user.name "user_name"
     
     // git commit에 사용될 email
     git config --global user.email "your_email@example.com"
     ```

   - 해당 폴더를 git에 올릴 로컬 저장소로 설정

     ```
     // 로컬 저장소로 사용할 위치로 이동
     cd "파일 경로"
     
     // 해당 폴더에서 VS Code를 바로 실행하는 명령어
     code .
     
     git init
     ```

   - git 명령어

     ```
     // 현재 상태를 보여준다
     git status
     
     // 현재까지의 log 를 보여준다
     git log
     ```

   - git push

     ```
     // git 로컬 저장소에 저장
     // 파일 별로 저장하는 방법
     git add (해당 파일)
     
     // 해당 경로의 폴더를 통째로 저장하는 방법
     git add .
     
     // add 후 commit
     git commit -m "commit comment"
     
     // 저장될 github의 원격 저장소 설정
     git remote add origin http://github 주소
     
     // 저장소로 밀어넣음
     // 최초 설정
     git push -u origin master
     
     // 설정 후에
     git push
     ```

   - github 저장소 내려받기

     ```
     // 최초 해당 github 원격 저장소의 내용 받기
     git clone http://내려받을 github 주소
     
     // 최초로 받은 뒤에는 아래 명령어만 쳐도 무방하다
     git pull
     
     // pull 받은 후에는 코드를 수정후 git push 과정 반복
     ```

     


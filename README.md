# Spring Practice

### Purpose
- 타임리프를 이용한 웹 페이지 API 작성과 Json 형식의 Rest API 작성
- Gradle 프로젝트 세팅 방법
- 테스트 코드 작성 양식과 그 흐름 이해

### How To Use
1. Docker를 이용해서 MySQL 실행하기
프로젝트를 폴더를 보시면 docker-compose.yml 파일이 있습니다 해당 파일에 mysql에 대한 실습 세팅이 모두 되어 있기 때문에 docker 만 설치되어 있다면 아래의 명령어를 통해서 바로 실행할 수 있습니다.

```yaml
docker compose up -d
```

2. 프로젝트 실행하기
    1. 인텔리제이로 실행하기 
    
        인텔리제이는 여러분이 커멘드라인으로 실행해야하는 대부분의 과정을 버튼하나로 실행할 수 있도록 도와줍니다. 
        실제로 배포할 때에는 커멘드라인으로 웹서버를 실행하는 법도 당연히 알고 있어야하지만 개발을 할 때에는 인텔리제이를 사용함으로써 편의성과 생상성을 높이는 것이 좋습니다.
        
    2. 커멘드 라인으로 실행하기
        1. jar file을 생성한다.
            - 윈도우
            ```
            ./gradlew.bat clean build
            ```
            - macos
            ```
            ./gradlew clean build
            ```
        2. ./build/lib 폴더를 들어가보면 jar 파일이 생성되어 있을 겁니다. 해당 파일을 실행합니다.
            ```
            java -jar ./build/lib/spring-practice-0.0.1-SNAPSHOT.jar        
            ```
        

### Tech Skill
> #### Backend
> - Spring MVC
> - Spring Data Jpa
> - Thymeleaf
> - Junit5
> 
> #### Database
> - MySQL

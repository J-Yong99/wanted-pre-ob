# wanted pob spring server

## ERD

<img width="1141" alt="erd" src="https://github.com/J-Yong99/wanted-pre-onboarding-backend/assets/77261304/05ba286b-7ade-4a0d-8e73-0c8e77f8e62e">

## 요구사항

1. 채용공고 등록
2. 채용공고 수정
3. 채용공고 삭제
4. 채용공고 전체 조회(채용내용 미포함)
5. 특정 채용공고 조회(채용내용 포함)
6. 채용공고 특정 단어로 검색기능
7. 사용자의 채용공고 지원

## api 설명

- [localhost:80/api-docs](http://localhost:80/api-docs)에 api마다 설명 추가

## 서버 실행방법

1. git clone을 이용해 프로젝트를 받아온다.
2. application.properties에 MySql 유저와 비밀번호를 설정한다.
3. dockefile과 docker-compose파일의 MySql 유저와 비밀번호를 설정한다.
4. 루트경로에서 “docker compose up”명령어로 디비와 서버를 동시에 실행시킨다.
5. 실행이 끝나면 “docker compose down”으로 종료한다.
- 또는 직접 MySql을 로컬 3306포트에서 실행시키고 스프링 어플리케이션을 실행시킨다.
- localhost:80에 서버가 실행된다. (단 도커로 실행했을 경우 80이고 도커를 사용하지 않을 경우 8080에 실행된다.)

## 테스트방법

1. 회사, 유저를 등록한다.
2. 회사 id를 이용해 채용공고를 등록한다.
3. 채용공고 검색, 수정, 삭제 테스트를 해본다.
4. 유저로 지원서를 등록해본다.(두 번 등록시 500에러)

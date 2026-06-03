# JCore - Java Programming Fundamentals Study

사내 학습동아리 **JCore(Java Core)** 의 운영 기록 및 학습 자료 저장소입니다.

본 스터디는 제가 직접 기획하고 운영한 학습 프로그램으로, Java 프로그래밍 기초부터 HTTP 통신, REST API, Spring Boot 기반 서버 프로그래밍 입문까지의 내용을 다루고 있습니다.

개발 경험이 많지 않은 구성원도 시스템의 동작 원리를 이해하고 개발자와 원활하게 소통할 수 있도록, 특정 기술을 깊게 파고들기보다 **"얕고 넓은 이해(Broad Understanding)"** 를 목표로 커리큘럼을 구성하였습니다.

---

## 👨‍🏫 My Role

본 학습동아리에서 아래 역할을 담당하였습니다.

- 커리큘럼 기획 및 설계
  - 「혼자 공부하는 자바」 교재 기반 커리큘럼 재구성
- 활동 일정 관리 및 진행
- 실습 과제 설계
- 코드 리뷰 및 질의응답
- 학습 아카이브 관리

---

## 🎯 Goal

실무에서는 직접 개발을 하지 않더라도 다양한 시스템을 운영하거나 개발자와 협업해야 하는 경우가 많습니다.

본 스터디는 아래와 같은 질문에 답할 수 있는 수준의 이해를 목표로 합니다. (초급자 팀원 기준)

- Java 프로그램은 어떻게 실행되는가?
- JDK와 JVM은 어떤 역할을 하는가?
- 객체지향 프로그래밍은 무엇인가?
- 시스템은 어떻게 서로 통신하는가?
- HTTP와 REST API는 무엇인가?
- Spring Boot 기반 서버는 어떻게 동작하는가?
- 사내 시스템들은 어떤 방식으로 연계되는가?

---

## 📚 Learning Scope

### Java Fundamentals

- Java 언어 기본 문법
- 변수와 자료형
- 조건문과 반복문
- 클래스와 객체지향
- 배열과 컬렉션
- 코드 구조 이해

### HTTP & API

- 네트워크와 프로토콜
- HTTP Request / Response
- HTTP Method
- REST API
- API 문서 읽기
- Postman 실습

### Server Programming

- Web Server와 WAS
- Servlet과 Tomcat
- Spring Boot 기초
- REST API 서버 구현

---

## 📖 Curriculum

### Part 1. Java Fundamentals

| 차시 | 주제                                                  |
| ---- | ----------------------------------------------------- |
| 1    | JDK, JVM, 컴파일 과정, 빌드 도구(Gradle/Maven)        |
| 2    | 변수와 타입, 연산자                                   |
| 3    | 조건문과 반복문                                       |
| 4    | 클래스 (객체지향, 필드, 메서드, 패키지와 접근 제한자) |
| 5    | 배열과 컬렉션 프레임워크                              |
| 6    | 객체지향 및 코드 구조 분석 Wrap-up                    |

### Part 2. HTTP & API

| 차시 | 주제                                       |
| ---- | ------------------------------------------ |
| 7    | HTTP 기초 1 - 프로토콜과 시스템 간 통신    |
| 8    | HTTP 기초 2 - HTTP 메서드, 요청/응답 분석  |
| 9    | REST API 개념, API 문서 읽기, Postman 실습 |

### Part 3. Server Programming

| 차시 | 주제                                                |
| ---- | --------------------------------------------------- |
| 10   | 서버 프로그래밍 기초 (Servlet, Tomcat, Spring Boot) |
| 11   | Spring Boot REST API 구현 실습                      |
| 12   | 전체 흐름 정리 및 시스템 연계 구조 분석             |

---

## 🧩 Learning Roadmap

```text
Java
 ↓
객체지향 프로그래밍
 ↓
HTTP
 ↓
REST API
 ↓
Spring Boot
 ↓
Server Programming
 ↓
System Integration
```

---

## 📝 Study Operation

- 주 1회 진행 (화요일 17:30 ~ 19:00, 매 주 취합 및 공지)
- 발표 및 토론 중심 운영
- 주차별 발표자 선정
- 실습 과제 진행
- 코드 리뷰 및 피드백
- 학습일지 작성

---

## 📂 Repository Structure

```text
사내_학습동아리
│
├── README.md
│
├── 학습내용 // 학습 내용 업로드
│   ├── 01_JDK_JVM_빌드도구
│   ├── 02_변수와_타입
│   ├── 06_OOP_Wrapup
│   ├── 07_HTTP_기초
│   └── ...
│
└── 과제 // 과제 수행 내용 업로드
    ├── 1주차
    ├── 2주차
    └── ...
```

---

## 📚 Textbook & Learning Materials

본 스터디는 아래 교재를 중심으로 커리큘럼을 구성하였습니다.

### Main Textbook

- 『혼자 공부하는 자바 (개정판)』
  - 저자: 신용권
  - 출판사: 한빛미디어

Java 기초 문법 및 객체지향 개념은 해당 교재를 기반으로 학습하였으며,
실무 연계 내용(HTTP, REST API, Spring Boot 등)은 별도 강의 자료를 제작하여 진행하였습니다.

---

## 🚀 Outcome

이 스터디는 프로그래밍을 처음 접하는 구성원도 Java 애플리케이션의 구조와 HTTP 기반 시스템 연계 방식을 이해할 수 있도록 설계되었습니다.

코드를 작성하는 능력 자체보다, 시스템이 어떻게 동작하는지 이해하고 설명할 수 있는 역량을 기르는 것을 목표로 합니다.

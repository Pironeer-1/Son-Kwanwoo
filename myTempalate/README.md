### 코드 컨벤션

<details> 
  <summary>1. 폴더 구조</summary>

- 각 도메인은 기능별로 나누어져 있으며, `board`, `member`, `global`로 구분.
- `global` 폴더에는 전역적으로 사용될 설정 파일, JWT, 예외처리가 포함됨.

- **세부 컨벤션**:
    - DTO 클래스는 `request`와 `response`로 세분화되어 요청 및 응답 데이터를 명확하게 구분.

</details>

<details> 
  <summary>2. 클래스 및 파일 명명 규칙</summary>

- **명명 규칙**:
    - 클래스 이름은 기능을 명확하게 나타내도록 작성(`MemberLoginReq`, `MemberSignupReq`). <br>
    - 요청 관련 DTO는 `Req`로, 응답 관련 DTO는 `Response` 또는 `Res`로 명명. <br>
    - 각 계층의 파일 이름은 `BoardController`, `BoardService`처럼 도메인 이름을 접두어로 사용하여 일관성 유지.

</details>

<details> 
  <summary>3. 비즈니스 로직</summary>

- 서비스 계층에서 리포지토리와 상호작용하여 비즈니스 로직을 처리. <br>
- `CustomException` 및 `ErrorCode`를 사용하여 일관된 예외 처리가 이루어지며, 전역 예외 핸들러에서 처리.

</details>

<details> 
  <summary>4. 응답 및 에러 처리</summary>

- **표준화된 응답**:
    - `SingleResult`, `ListResult`, `SuccessResponse` 등의 응답 구조를 사용하여 규격화된 응답을 반환.

- **에러 처리**:
    - `ErrorCode` 및 `ExceptionAdvice`를 사용하여 일관된 에러 응답을 제공.

</details>

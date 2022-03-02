# hh99_magazine

### API

#### 게시글 (/api/posts)

| NO  |    URL     | METHOD |                BODY                 |    RETURN     |   DESC    |
|:---:|:----------:|:------:|:-----------------------------------:|:-------------:|:---------:|
|  1  |     /      |  GET   |                                     | (비로그인) 전체 게시글 | 전체 게시글 조회 |
|  2  |  /signed   |  GET   |                                     | (로그인) 전체 게시글  | 전체 게시글 조회 |
|  3  |     /      |  POST  |        name, title, content         |    게시글 정보     |  게시글 작성   |
|  5  |  /:postId  | PATCH  |        name, title, content         |    게시글 정보     |  게시글 수정   |
|  6  |  /:postId  | DELETE |                                     |      메세지      |  게시글 삭제   |  

#### 사용자 (/api)

| NO  |   URL   | METHOD |                   BODY                   | RETURN | DESC |
|:---:|:-------:|:------:|:----------------------------------------:|:------:|:----:|
|  1  | /signup |  POST  | username, name, password, check_password |  메세지   | 회원가입 |
|  2  | /signin |  POST  |            username, password            |  메세지   | 로그인  |

#### 좋아요 (/api/favorite)

| NO  |   URL    | METHOD | BODY | RETURN |  DESC  |
|:---:|:--------:|:------:|:----:|:------:|:------:|
|  1  | /:postId |  POST  |      | 게시글 정보 | 좋아요 토글 |

<br/>

### Domain

![domain](./img/domain.png)
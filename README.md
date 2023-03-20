# 2023 42 Hackathon API

---
![15minIsEnough](https://user-images.githubusercontent.com/43363413/226223342-975c6feb-32b0-4226-8074-d27f8d10c140.png)


### User

- user 정보 받아오기
    
    `(https://api.evaluation.42seoul.link/user/{intraId})`
    
    ```python
    /*
        Form : (/user/{intraId})
        - example : http://13.209.130.135/user/gehan
        - Return type : json
        - {
            "pid":271,
            "userId":135416,
            "intraId":"gehan",
            "image":"https://cdn.intra.42.fr/users/7b812d6295638cb4ab865e282a66ca82/small_gehan.jpg",
            "blackhole":"2023-08-20T15:00:00.000+00:00",
            "level":85,
            "outstandingRate":null
            "circle":3
    	   }
        - Response Status Code
          200 : request was succesful
          400 : userId not found in Databaes
          404 : request error (API 명세 확인)
          502 : server is not running
      */
    ```
    

### Feedback 정보 받아오기

- Feedback 정보 userId로 받아오기
    
    `(https://api.evaluation.42seoul.link/comment/{type}={intraId})`
    
    ```python
    /*
        Form : (/comment/{type}={userId})
        - {type} - String : "corrector", "corrected"
            corrector(평가한 것) example : .../comment/corrector=135416
            corrected(평가받은 것) example : .../comment/corrected=135416
   
          - {userId} - Integer : userId (주의!! intraId 아님)
        - Return type : json Array
        - [{
            "pid":18984,
            "correctionId":5116560,
            "comment":"cpp 과제 평가를 많이 다녀봤지만 ....",
            "feedback":"평가자분께서 cpp 및 객체 지향을 ....",
            "finalMark":90,
            "flagOutstanding":true,
            "corrector":135416,
            "corrected":103895,
            "createdAt":"2023-02-25T18:39:36.000+00:00",
            "projectId":1341,
            "projectName":"cpp-03"
           }, ...]
        - Response Status Code
          200 : request was succesful
          400 : request error (API 명세 확인)
          502 : server is not running
    */
    ```
    
- Feedback 정보 projectName으로 받아오기
    
    `(https://api.evaluation.42seoul.link/comment/{type}={intraId}/{projectName)`
    
    ```python
    /*
        Form : (/comment/{type}={userId}/{projectName})
        - {type} - String : "corrector", "corrected"
        - {userId} - Integer : userId (주의!! intraId 아님)
        - {projectName} - String : "과제이름"

                0서클 "libft"
                1서클 "ft_printf" "get_next_line" "born2beroot"
                2서클 "push_swap" "fdf" "pipex" "so_long" "fract-ol" "minitalk"
                3서클 "philosophers" "minishell"
                4서클 "cub3d" "minirt" "cpp-00" "cpp-01" "cpp-02" "cpp-03" "cpp-04" "net_practice"
                5서클 "ft_irc" "webserv" "inception" "cpp-05" "cpp-06" "cpp-07" "cpp-08" "cpp-module-09"
                6서클 "ft_transcendence"
                
        - Return type : json Array
        - Response Status Code
          200 : request was succesful
          400 : request error (API 명세 확인)
          502 : server is not running
     */
    ```
    
- Feedback 정보 circle로 받아오기
    
    `(https://api.evaluation.42seoul.link/comment/{type}={intraId}/circle={circle)`
    
    ```python
    /*
        Form : (/comment/{type}={userId}/circle={circle})
        - {type} - String : "corrector", "corrected"
        - {userId} - Integer : userId (주의!! intraId 아님)
        - {circle} - Integer : 서클
        - Return type : json Array
 */
    ```

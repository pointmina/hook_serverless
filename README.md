
<details><summary>1. kakao login -> google login ☑️</summary> 
    - https://visualandroidblog.blogspot.com/2023/04/google-sign-in-firebase-android-kotlin-tutorial.html <br> <br>
    - https://developers.google.com/android/guides/setup?hl=ko <br> <br>
    - https://www.youtube.com/watch?v=H_maapn4Q3Q <br> <br>
    - https://firebase.google.com/docs/auth/android/start?hl=ko&_gl=1*tfveyn*_up*MQ..*_ga*Nzk2MDYxODgwLjE3MTI0MjI2ODI.*_ga_CW55HF8NVT*MTcxMjQyMjY4Mi4xLjAuMTcxMjQyMjY4Mi4wLjAuMA.. <br> <br>
    - https://console.firebase.google.com/u/0/project/hook-882c5/settings/general/android:com.hanto.Hook?hl=ko <br> <br>

</details>




2. 설정 버튼 누르면☑️
- 로그아웃 버튼
- 유저 정보 나오게

https://github.com/pointmina/Hook/assets/68779817/14745caf-0b3f-4546-bfee-3a9b5a55f393

2024 04 08 -> 8th commit
-

0. 레이아웃 만들기, 함수 만들기 ☑️

2. ![image](https://github.com/pointmina/Hook/assets/68779817/8252ed3e-6185-425f-b675-a1a82247cad5)   ☑️
<details><summary>리사이클러뷰에 리사이클러뷰 삽입</summary> 

- https://velog.io/@simsubeen/Android-Kotlin-RecyclerView-%EA%B0%80%EB%A1%9C-%EC%A0%95%EB%A0%AC-GridLayoutManager <br> <br>
- https://notepad96.tistory.com/201 <br><br>
- https://jinsangjin.tistory.com/25 <br><br>
- https://developer.android.com/develop/ui/views/layout/recyclerview?hl=ko <br><br>
 </details>

2. ![image](https://github.com/pointmina/Hook/assets/68779817/6ea96baf-456a-4a62-ad78-0b48cf506f49) ☑️
- 글자길이 수에따라 가로로 길어져야함
- 겉에 껍데기 가로 길이를 wrap_content로 만들고 text를 외부 데이터에서 받아오는 방식

☑️클리어 문제는 tag_item layout에서 match_parent여서 한줄을 다 차지하고 있던거였음 삽질 완.☑️

2024 04 09 -> 9th commit

1. 8일꺼 나머지 ☑️

2024 04 10 -> 9.5th
-

1) 홈뷰 -> setting 을 add hook으로 바꿈☑️
- navigation loginTestActivity -> addHookActivity로 경로 변경

2) 새로운 hook 뷰 만들기 ☑️

3) down_arrow 버튼 누르면 기타 정보 나오고 up_arrow로 변경 그 반대도☑️

4) 새로운 훅에서 링크 정보 누르면 키보드 자동으로 나오고 안에 정보 입력할 수 있게☑️

5) 버전 업글 ☑️
- https://developer.android.com/build/agp-upgrade-assistant?hl=ko

6) 태그 수정 : 바텀 시트 or fragment, 커스텀 알림 😵 ✖️
- https://www.tutorialsbuzz.com/2019/09/android-multichoice-alertdialog-kotlin.html

2024 04 11 -> 10th
-

<details><summary>1) 카카오 로그인으로 바꾸기 ☑️ </summary> 
- https://velog.io/@mong7399/Android-StudioKotlin-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B5%AC%ED%98%84 <br>
- 해시키 오류 <br>
- 일단 구글 로긴으로 걸어놈 (앱 진행사항 확인을 위해) <br>
 </details>

<details><summary>2) 훅 추가 뷰 : 태그 추가/ 수정 : Confirmation dialog ☑️ </summary> 
- https://www.tutorialsbuzz.com/2019/09/android-multichoice-alertdialog-kotlin.html <br>
- https://m2.material.io/components/dialogs#confirmation-dialog <br>
- 선택한거 태그 뷰에 반영 <br>
</details>

3) 백 버튼 누르면 뒤로가기 ☑️

2024 04 14 -> 11th
-

<details><summary>1. Tag뷰 리사이클러 뷰 삽입</summary> ☑️
- https://developer.android.com/reference/com/google/android/material/chip/Chip 으로 바꿔야 할듯 <br>
- https://android-developers.googleblog.com/2017/02/build-flexible-layouts-with.html 아니면 이거 justify<br>
- https://stickode.tistory.com/403<br>
</details>

2024 04 15 -> 12th
-

1. Tag뷰 flexBox 삽입 ☑️
2. 최근에 저장한 훅 태그 리사이클러뷰 flexBox로 교체☑️

2024 04 16 -> 13th
-

1. 태그 뷰에서 리사이클 뷰 누르면 전환 ☑️
2. 태그 뷰 리사이클러 삽입 ☑️
3. 수정하기 누르면 fragment ☑️
4. 태그 선택창에 add 삽입 ☑️



To Do
-
1. 서버에서 데이터 받아오기
2. 새로운 훅 추가하면 리사이클러뷰에 데이터 반영하기
3. 태그 add 버튼 추가? / 태그 뷰에서도..? ㅇㅅㅇ..







페이로드
-
안녕하세요! 콘솔에 찍힌 페이로드 내용말씀이신걸까요? 코드상으론 없지만 log.info()를 통해서 Payload값을 직접 찍어서 확인했습니다!

payload에서 값을 꺼내는 방법은 아래 링크 참고하시면 도움되실것 같아요!

https://developers.google.com/identity/gsi/web/guides/verify-google-id-token?hl=ko#using-a-google-api-client-library 


추가 기능 (여유가 있다면)
-

1. 모션으로 바텀 네비게이션 넘기기
2. 리사이클러뷰 위로 당기면 새로고침

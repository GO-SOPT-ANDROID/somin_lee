# *Seminar2 과제 Description*

## *필수 과제*
### RecyclerView의 바깥에 있어 스크롤 되지 않는 헤더를 스크롤 되게 변경
- [x] 리스트 위에 Title 텍스트를 하나 넣는다
- [x] 화면에 리스트를 다 담을 수 없는 경우 하단으로 스크롤 할 때 헤더도 같이 따라 내려가야 한다

## *심화 과제*
### BottomNavigation의 기능 추가하기
- [ ] BottomNavigation에 버튼이 눌려져 있을 때 한번 더 누르면 현재 스크롤 위치에서 상단으로 갈 수 있게 (Scroll To Top) 기능을 추가
### Fragment 생명주기 알아보기
- [ ] Fragment의 생명주기에 대해 어떤 것이 있는지, 각 생명주기에는 어떤 로직을 실행해야하는지 찾아보고 이를 블로그, 노션 등에 정리하여 리드미에 링크 남기기
### RecyclerView 성능 조금 더 개선하기
- [ ] NotifyDataSetChanged를 활용하면 발생하는 문제점을 개선한 DiffUtil, ListAdapter 기능 각각의 역할을 조사 및 적용하기

## *PR point*
- 어떤 점 위주로 봐야할 지 요약

## *Screenshot*
- 사진이나 영상 업로드

<img src="" width="360"/>

---

## 템플릿 설명
레포지터리에는 총 2개의 브랜치가 있습니다.
### main
가장 기본이 되는 브랜치입니다. 새로운 연습 환경을 만들고자 할때 이 브랜치에서 새로운 브랜치를 파셔서 만드시면 됩니다.
### develop
대부분의 과제는 이 브랜치에서 이뤄집니다.
develop/view 브랜치에서 새로운 feature 브랜치(seminar1, week1, feature/1 등 자유)를 파고 작업을 진행하면서
과제를 완료하면 해당 과제를 develop PR을 올려주시고 금잔디조원들에게 코드리뷰를 받으시면 됩니다 !
머지까지 완료하시면 과제 완료로 인정하겠습니다 !
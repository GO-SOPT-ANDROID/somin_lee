# *[Seminar2]* 과제 Description

## *PR point*
- 필수과제 : Multi-View Type RecyclerView / ConcatAdapter 두 방식 중 전자를 이용했습니다!
- 질문 : MultiViewAdapter.kt 에서 주석에 답해주시면 매우 감사하겠습니다.
- HeaderViewHolder의 onBind에서 SomData Class를 item으로 받는데, 코드가 돌아는 가지만 왠지 이렇게 하는 게 아닌 것 같아요..
  그래서 String으로 고치려 했는데 자꾸 Crash 남ㅋㅋ

---

## *필수 과제*
### 문제 1. RecyclerView의 바깥에 있어 스크롤 되지 않는 헤더를 스크롤 되게 변경
- [x] 리스트 위에 Title 텍스트를 하나 넣는다
- [x] 화면에 리스트를 다 담을 수 없는 경우 하단으로 스크롤 할 때 헤더도 같이 따라 내려가야 한다
  
## *심화 과제*
### 문제 1. BottomNavigation의 기능 추가하기
- [x] BottomNavigation에 버튼이 눌려져 있을 때 한번 더 누르면 현재 스크롤 위치에서 상단으로 갈 수 있게 (Scroll To Top) 기능을 추가
### 문제 2. Fragment 생명주기 알아보기
- [ ] Fragment의 생명주기에 대해 어떤 것이 있는지, 각 생명 주기에는 어떤 로직을 실행해야하는지 찾아 보고 이를 블로그, 노션 등에 정리하여 리드미에 링크 남기기
### 문제 3. RecyclerView 성능 조금 더 개선하기
- [ ] NotifyDataSetChanged를 활용하면 발생하는 문제점을 개선한 DiffUtil, ListAdapter 기능 각각의 역할을 조사 및 적용하기

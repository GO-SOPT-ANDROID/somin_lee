package org.android.go.sopt.model

import androidx.lifecycle.ViewModel
import org.android.go.sopt.R

class HomeViewModel : ViewModel() {
    val mockAnimationList = listOf<RecycleAnimationData>(
        RecycleAnimationData(
            type = HEADER,
            imgId = R.drawable.sopt_android,
            name = "헤더",
            detail = "✨ 내가 본 만화 ✨"
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.mononoke,
            name = "모노노케 히메",
            detail = "에미시 족의 일원인 아시타카는 마을을 쑥대밭으로 만드는 재앙신을 저지하는 과정에서 팔에 저주를 받는다. 재앙신의 저주를 풀기 위해 길을 나선 그는 강력한 화력으로 무장한 타타라 마을의 지도자 에보시를 만난다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.star_child,
            name = "별을 쫓는 아이",
            detail = "2011년 공개된 신카이 마코토 감독의 일본 애니메이션 판타지 영화이다. 2011년 5월 7일 개봉되었다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.your_name_is,
            name = "너의 이름은",
            detail = "2016년 공개된 신카이 마코토 감독의 일본 애니메이션 로맨스 판타지 드라마 영화이다. 코믹스 웨이브 필름 제작 작품. 이 영화는 일본 시골의 여고생과 도쿄의 남고생의 몸이 서로 바뀌는 이야기를 다룬다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.chainsawman,
            name = "체인소 맨",
            detail = "후지모토 타츠키가 그리고 집필한 일본 만화이다. 슈에이샤의 소년 만화 잡지 《주간 소년 점프》에서 제1부 '공안편'이 2018년 12월부터 2020년 12월까지 연재되었다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.cyberpunk_edgerunner,
            name = "사이버펑크: 엣지러너",
            detail = "CD 프로젝트 레드의 비디오 게임 《사이버펑크 2077》에 기반한 2022년 사이버펑크 일본 웹 애니메이션이다. CD 프로젝트의 감독하에 트리거가 제작을 맡았으며 넷플릭스를 통해 2022년 9월 방영됐다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.saka_days,
            name = "사카모토 데이즈",
            detail = "일본의 액션·코미디 만화. 작가는 스즈키 유우토. 현대의 일본이 배경이며, 전직 킬러를 중심으로 킬러 세계의 싸움을 그리고 있다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.jutsu_kaisen,
            name = "주술회전",
            detail = "일본의 만화가인 아쿠타미 게게가 그린 만화이자 이를 원작으로 한 애니메이션이다. 주간 소년 점프의 2018년 14호부터 연재 중이다. 점프 GIGA 2017 vol.1부터 2017 vol.4까지 연재된 《도쿄도립주술고등전문학교》를 공식 이전 이야기로 채택하였으며, 단행본 0권으로도 발매되었다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.jutsu_kaisen0,
            name = "극장판 주술회전 0",
            detail = "2021년 공개된 일본의 애니메이션 영화이다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.demon_slayer,
            name = "귀멸의 칼날",
            detail = "고토게 코요하루에 의해 만들어진 일본의 만화 작품이다. 슈에이샤의 《주간 소년 점프》에서 2016년 11호부터 2020년 24호까지 연재되었다. 단행본의 누적 발행 부수는 2021년 2월 시점에서 1억 5천만 부를 돌파했다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.attack_on_titan,
            name = "진격의 거인",
            detail = "이사야마 하지메의 만화이다. 소설, 텔레비전 애니메이션, 실사영화 등 미디어 믹스가 전개 중이다. 고단샤에서 발행하는 《별책 소년 매거진》을 통해 2009년 10월 호 부터 2021년 5월 호 까지 연재되었다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.haikyu,
            name = "하이큐!!",
            detail = "후루다테 하루이치가 그린 만화다. 하이큐의 뜻은 배구의 일본어 독음이다. 「주간 소년 점프」에서 2012년 제12호부터 2020년 33·34 합병호까지 연재했다. TV 애니메이션은 제1기가 2014년 4월 6일부터 9월 21일까지 방영되었다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.soul_eater,
            name = "소울 이터",
            detail = "소울 이터는 오쿠보 아츠시의 원작 만화 또는 원작 만화의 애니메이션 작품이다. 2008년 4월 방송을 시작하여 2009년 3월 30일에 종영하였다. 2020년 8월 현재 누적 판매량이 3200만 부를 기록하고 있다."
        ),
        RecycleAnimationData(
            type = CONTENT,
            imgId = R.drawable.doctor_stone,
            name = "닥터 스톤",
            detail = "모두가 돌이 되어 굳어진 이후 서력 5738년의 지구에서 문명과 인류를 되찾으려는 이야기를 그리고 있다. 주간 소년 점프에서 리이치로 원작의 보이치가 그린 일본의 판타지 SF 만화."
        )
    )

    companion object {
        const val HEADER = 0 // 헤더 뷰
        const val CONTENT = 1 // 리사이클러 아이템 뷰
    }
}
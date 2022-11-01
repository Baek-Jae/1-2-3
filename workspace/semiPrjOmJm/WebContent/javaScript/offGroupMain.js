
var txtArea = $('.addr');
if (txtArea) {
    txtArea.each(function () {
        $(this).height(this.scrollHeight);
    });
};

$('.show_comment_list').click(function(){
        $('#offGroup_comment_list').toggleClass('close');
        $('#offGroup_comment_list').css({"animation": "1s fadeIn ease"});
        $('.my_comment').toggleClass('close');
        $('.my_comment').css({"animation": "1s fadeIn ease"});
});

$('.offGroup_MemberList').click(function () {
    $('.offModal_member_wrap').toggleClass('close');
});

$('.memberlist_close').click(function () {
    $('.offModal_member_wrap').addClass('close');
});

function readyModify(obj) {
	const indexNo = $('.comment_modify').index(obj);
	console.log(indexNo);
	$($('.comment_modify')[indexNo]).click(function(){
		$($('.complate')[indexNo]).removeClass('close');
		$($('.comment_modify')[indexNo]).addClass('close');
		$($('.comment')[indexNo]).attr('readOnly', false);
		$($('.comment')[indexNo]).css('backgroundColor', 'rgba(255, 255, 255, 0.438)');
		});
};


//function complateModify(e){  //동적요소에 이벤트를 줘보자!
//	let complate = e.target;  //컴플릿을 만들어서 이벤트 타겟가져옴
//	while(!complate.classList.contains('complate')){ //이벤트 타겟에 컴플릿이라는 클래스 있는지 검사
//		complate = complate.parentNode; //없다면 부모요소에게 가기
//		
//		if(complate.nodeName == 'body'){ //바디까지 갔다면 반복문 중지
//			complate = null;
//			return;
//		}//조건문
//	}//반복문
//	
//	$(complate).click(complateController)//이벤트 타겟에 이벤트 걸어주기 
//	
//};//function
//	
//	
//
//$('.complate').click(complateModify);//동적요소에 이벤트 추가 함수 실행

//function complateController(e) {
//		const no = getIndex(e, this); //이벤트타겟의 인덱스 번호 호출
//		$($('.complate')[no]).addClass('close'); //화면 안보이게
//		$($('.comment_modify')[no]).removeClass('close'); //화면보이게
//		$($('.comment')[no]).attr('readOnly', true); //수정불가
//		$($('.comment')[no]).css('backgroundColor', 'transparent'); //부모요소의 색상
//		console.log(no); //혹시몰라 인덱스번호체크해보기
//};









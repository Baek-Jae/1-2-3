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
	$($('.comment_modify')[indexNo]).click(function(){
		$($('.complate')[indexNo]).removeClass('close');
		$($('.comment_modify')[indexNo]).addClass('close');
		$($('.comment')[indexNo]).attr('readOnly', false);
		$($('.comment')[indexNo]).css('backgroundColor', 'rgba(255, 255, 255, 0.438)');
		});
};

//const x = getIndex('click', $('.offGroup_info'));




function getIndex(e, obj){
	const  index = $(obj).index(e.target);
	return index;
}










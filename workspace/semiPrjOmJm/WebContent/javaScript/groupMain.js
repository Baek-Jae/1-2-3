var txtArea = $('.addr');
if (txtArea) {
    txtArea.each(function () {
        $(this).height(this.scrollHeight);
    });
}



const closebtnArr = document.querySelectorAll('.offGroup_close');
const offModalArr = document.querySelectorAll('.offModal_wrap');
const openmodalArr = document.querySelectorAll('.show');
const offContent = document.querySelectorAll('.offGroup_content');
const offInfo = document.querySelectorAll('.offGroup_info');


for (let i = 0; i < offModalArr.length; ++i) {
  closebtnArr[i].addEventListener('click', function () {
      offModalArr[i].classList.add('close');
  });

//  openmodalArr[i].addEventListener('click', function () {
//      offModalArr[i].classList.remove('close');
//      offContent[i].style.height = offContent[i].scrollHeight + 'px';
//      offInfo[i].style.height = 300 + offContent[i].scrollHeight + 'px';
//  });

}

$('#like').click(()=>{
	$('#dontLike').removeClass("close");
	$('#like').addClass("close")
	
});

 $('#dontLike').click(()=>{
	$('#like').removeClass("close");
	$('#dontLike').addClass("close")
	
});

$('.memberlist_close').click(()=>{
	$('.gmember_wrap').addClass("close");
});
	
$('#groupMember').click(()=>{
	$('.gmember_wrap').toggleClass("close");	
})	

$('#group-menu-content').click(()=>{
	$('.gmember_wrap').removeClass("close");	
})
var txtArea = $('.addr');
if (txtArea) {
    txtArea.each(function () {
        $(this).height(this.scrollHeight);
    });
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
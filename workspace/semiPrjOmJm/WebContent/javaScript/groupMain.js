var txtArea = $('.addr');
if (txtArea) {
    txtArea.each(function () {
        $(this).height(this.scrollHeight);
    });
}





const closebtnArr = document.querySelectorAll('.offGroup_close');
const offModalArr = document.querySelectorAll('.offModal_wrap');
const openmodalArr = document.querySelectorAll('.show');
const offContent = document.querySelectorAll('offGroup_content');

console.log(closebtnArr);
console.log(offModalArr);
console.log(openmodalArr);
for (let i = 0; i < offModalArr.length; ++i) {
    closebtnArr[i].addEventListener('click', function () {
        offModalArr[i].classList.add('close');
    });

    openmodalArr[i].addEventListener('click', function () {
        offModalArr[i].classList.remove('close');
        offContent[i].height(offContent[i].scrollHeight);
    });
}
function textbyte(obj, maxByte) {
  let str = obj.value; 
  let strLen = str.length; 

  let rbyte = 0;
  let rlen = 0; 
  let one_char = '';
  let str2 = '';
  
  obj.style.height = '5px';
  obj.style.height = 30 + obj.scrollHeight + 'px';
  
  for (let i = 0; i < strLen ; i++) {
      one_char = str.charAt( i);
       
      if (escape(one_char).length > 4) {
          rbyte += 2;
          console.log(rbyte); 
          console.log(byteInfo);
      } else {
          rbyte++;
      };

      if (rbyte <= maxByte) {
          
          rlen = i + 1;
      };
  }; //for

  if (rbyte > maxByte) {
      alert('한글 ' + maxByte / 2 + '자 / 영문 ' + maxByte + '자를 초과 입력할 수 없습니다.');
      str2 = str.substr(0, rlen);
      obj.value = str2; 
      console.log(str2);
      textbyte(obj, maxByte); 
  } else {
      document.getElementById('byteInfo').innerText = rbyte; 
  }
}





let xhr
let checkFirst = loopSend=false;
let kbs;

function sijak(){
	if(checkFirst===false){
		kbs=setTimeout("sendkeyword()", 800);
		loopSend=true;
	}
}

function sendkeyword(){
	//console.log("a");
	let keyWord=document.frm.keyword.value; 
	//console.log(keyWord);
	
	if(keyWord===""){
		hide();
	}else{
		xhr=new XMLHttpRequest();
		let para="keyword=" +keyWord;
	xhr.open("get", "jq8.jsp?"+para, true);
	xhr.onreadystatechange= function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
			process();
		}else{
			alert("요청실패:"+xhr.status);
		}
			}
	}
	xhr.send(null);
	}
	clearTimeout(kbs); //setTimeout 설정 해제
}

function process(){
	let resultData=xhr.responseText;
	//console.log(resultData);
	let result= resultData.split("|");
	//console.log(`건수:${result[0]} 자료:${result[1]}`);
	let tot = result[0];
	if(tot > 0){
		let datas= result[1].split(",");
		let imsi="";
		for(let i=0; i<datas.length; i++){
			imsi+= "<a href=\"javascript:func('"+ datas[i]+"')\">" + datas[i]+ "</a><br>";
		}
		console.log(imsi);
		document.querySelector("#suggestList").innerHTML = imsi;
		show();
	}
}
function func(reData){
	//alert(reData);
	frm.sel.value=reData;
	loopSend=checkFirst =false;
	hide();
	
	frm.keyword.value = "";
}
function hide(){
	document.querySelector("#suggest").style.display="none";
}

function show(){
	document.querySelector("#suggest").style.display="";
}
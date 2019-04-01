function testFunction(){
	alert(" test JS function called");
}

function displayBooks(event){
	//alert(" display Books called");
 	event.preventDefault();
 	var xhttp = new XMLHttpRequest();
 	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {	
		 document.getElementById("storeSubject").classList.remove('active');
		 document.getElementById("storeSubject").classList.add('fade');
		 document.getElementById("book").classList.remove('fade');
		 document.getElementById("book").classList.add('active');	    	
	     document.getElementById("book").innerHTML = this.responseText;
	    }
	  };
	 xhttp.open("GET", "/bookstore/books", true);
	 xhttp.send();
}


function displaySubjects(event){
	//alert(" display Subjects called");
 	event.preventDefault();
 	var xhttp = new XMLHttpRequest();
 	  xhttp.onreadystatechange = function() {
 		  
	    if (this.readyState == 4 && this.status == 200) {
		 document.getElementById("book").classList.remove('active');
		 document.getElementById("book").classList.add('fade');
		 document.getElementById("storeSubject").classList.remove('fade');
		 document.getElementById("storeSubject").classList.add('active');	    	 
	     document.getElementById("storeSubject").innerHTML = this.responseText;
	     //document.getElementById("storeSubject").innerHTML ="test mesage;"
	    }
	  };
	 xhttp.open("GET", "/bookstore/subjects", true);
	 xhttp.send();
}

/* Books */

$( "#book" ).submit(function( event ) {
	  alert( "Handler for .submit() called." );
	  event.preventDefault();
});

function addBook(event){
	//alert(" Add book function called");
	console.log(event);
	
	event.preventDefault();
	var xhttp = new XMLHttpRequest();
	var form = document.getElementById("bookForm");
  var data = new FormData(form);
	//alert("calling http request");
	  xhttp.onreadystatechange = function() {
		  	//alert(this.readyState);
		 	//alert(this.responseText);
	    if (this.readyState == 4 && this.status == 200) {	   
	     document.getElementById("showBooks").innerHTML = this.responseText;
	    }
	  };
	  
	  
	 xhttp.open("POST", "/bookstore/addBook", true);
	 xhttp.send(data);
}

function searchBook(event){
	//alert(" Search book function called"); 	
	var id = parseInt(document.getElementById('bookId').value);
	//alert("ID" + id);
	var title = document.getElementById('bookTitle').value;
	//alert("Title" + title);
	event.preventDefault();
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {	   
	     document.getElementById("showBooks").innerHTML = this.responseText;
	    }
	  };
	  if(!isNaN(id)){
		  xhttp.open("POST", "/bookstore/searchBookById?id="+id, true);
	  }
	  else{
		  xhttp.open("POST", "/bookstore/searchBookByTitle?title="+title, true);
	  }
	  
	 xhttp.send();
}

function deleteBook(event){
	//alert(" Search book function called"); 	
	var id = parseInt(document.getElementById('bookId').value); 	
	
	event.preventDefault();
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {	   
	     document.getElementById("showBooks").innerHTML = this.responseText;
	    }
	  };
	 xhttp.open("POST", "/bookstore/deleteBook?id="+id, true);
	 xhttp.send();
}

/* Subjects */

function searchSubject(event){
	//alert(" Search book function called"); 	
 	var subject_id = parseInt(document.getElementById('subject_id').value); 
 	//alert("ID" + subject_id);
 	var duration = parseInt(document.getElementById('duration').value);
 	//alert("Duration" + duration);
 	event.preventDefault();
 	var xhttp = new XMLHttpRequest();
 	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {	   
	     document.getElementById("showSubjects").innerHTML = this.responseText;
	    }
	  };
	  if(!isNaN(subject_id)){
		  //alert("Callling id");
		  xhttp.open("POST", "/bookstore/searchSubjectById?id="+subject_id, true);
	  }
	  else{
		 // alert("Callling duration");
		  xhttp.open("POST", "/bookstore/searchSubjectByDuration?duration="+duration, true);
	  }
	 
	 xhttp.send();
}

function deleteSubject(event){
	//alert(" Search book function called"); 	
 	var id = parseInt(document.getElementById('subject_id').value); 	
 	event.preventDefault();
 	var xhttp = new XMLHttpRequest();
 	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {	   
	     document.getElementById("showSubjects").innerHTML = this.responseText;
	    }
	  };
	 xhttp.open("POST", "/bookstore/deleteSubject?id="+id, true);
	 xhttp.send();
}

function addSubject(event){
	//alert(" Add book function called");
 	console.log(event);
 	
 	event.preventDefault();
 	var xhttp = new XMLHttpRequest();
 	var form = document.getElementById("subjectForm");
    var data = new FormData(form);
	//alert("calling http request");
 	  xhttp.onreadystatechange = function() {
 		  	//alert(this.readyState);
		 	//alert(this.responseText);
	    if (this.readyState == 4 && this.status == 200) {	   
	     document.getElementById("showSubjects").innerHTML = this.responseText;
	    }
	  };
	  
	  
	 xhttp.open("POST", "/bookstore/addSubject", true);
	 xhttp.send(data);
}

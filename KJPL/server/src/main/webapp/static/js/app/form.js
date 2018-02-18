$(document).ready(function(){
             
/***********************************************************************************************************************/       
//*****************************              Hands Entry Form                 ***************************************
/**********************************************************************************************************************/
	
	
       $("#DailyHands-FormSubmit #DailyHands-FormBody .form-control").on("change blur keyup",function(e){
        obj = $(this)
        
        try{
            if(isNaN(obj.val())) throw "Not a number";
        } catch(err){
            obj.addClass("is-invalid")
            obj.trigger("focus");
            return false;
        }
            obj.removeClass("is-invalid")
            idVal = obj.attr("id");
            rowNum = idVal.substring(0,4);
            temp=0;
            for(i=1;i<=3;i++){
                    temp=temp+parseInt($("#"+rowNum+i).val())
            }
            $("#"+rowNum+4).val(temp);
            
            if(e.keyCode === 13){

                _colIndex = parseInt(idVal.substring(4,5));
                if(_colIndex === 4 ){
                    _rowIndex = parseInt(idVal.substring(3,4));
                    $('#row'+(_rowIndex+1)+(1)).focus();
                    e.preventDefault();
                } else {
                    $('#'+rowNum+(_colIndex+1)).focus();
                    e.preventDefault();
                }
            }
            return true;
       });

       $("#DailyHands-FormSubmit #DailyHands-FormBody .form-control").on("focus",function(e){
        $(this).select();
       });

       $("#DailyHands-FormSubmit #submit").on("click", function(){
            validateForm(this)
       });

       function validateForm(obj){

            alert('hello')


       };

/***********************************************************************************************************************/       
//*****************************              Rate entry Form                 ***************************************
/**********************************************************************************************************************/    

/**
* On Submit it will hide the Date list and open the date field
* The submit will work for both Update and submit
*/
       $('#RateEntry #submit').on('click', function(){
    	   
    	   $('#RateEntry #entryDateDiv').show();
    	   $('#RateEntry #updateDateDiv').hide();
    	   
    	   
    	   var json={};
    	   
    	   if(requestObject.operationName === requestObject.operationType.UPDATE){
    		   json['id']=parseInt($('#updateEntryDate').val());
    		   json[$('#entryDate').attr('name')]=$('#updateEntryDate option:selected').html();
    	   } else if(requestObject.operationName === requestObject.operationType.SAVE){
    		   var rateEntryDate =$('#RateEntry #entryDate').val();
        	   if(rateEntryDate === '' || rateEntryDate === 'undefined'){
        		   alert(requestObject.formMessage.error['Date']);
        		   return false;
        	   }
        	   json[$('#entryDate').attr('name')]=rateEntryDate;
    	   } else{
    		   alert(requestObject.formMessage.error['Operation'])
    	   }
    	   
    	   console.log($('#RateEntry-FormBody :input[type=text]').length);
    	   $('#RateEntry-FormBody :input[type=text]').each(function(index,data){
    		   json[$(data).attr('name')]=$(data).val();
    	   })
           console.log(json);
           var payload = requestObject.call(requestObject.methodType.POST, requestObject.appURL.RateEntry[requestObject.operationName], JSON.stringify(json))
           console.log(payload);
           $('#RateEntry form')[0].reset();
    	   $('#updateEntryDate option').remove();
    	   setDate();
       });
       
       
/**
* The action for query is to search the rate in database and populate the Date List Field
*/
       
       $('#RateEntry #query').on('click', function(){
    	   requestObject.operationName=requestObject.operationType.QUERY;
    	   $('#RateEntry #updateDateDiv').show();
    	   $('#RateEntry #entryDateDiv').hide();
    	   $('#RateEntry form')[0].reset();
    	   $('#updateEntryDate option').remove();
    	   	
    	   var payload = requestObject.call(requestObject.methodType.GET, 
    			   							requestObject.appURL.RateEntry[requestObject.operationName],
    			   							"");
    	   var option = '';
    	   option +='<option value="">select</option>'
    	   $.each(payload, function(index, value){
    		   var date = new Date(value.entryDate);
    		   option += '<option value="'+ value.id + '">' + date.getDate()+'/'+(parseInt(date.getMonth())+1)+'/'+date.getFullYear() + '</option>';
    	   });
    	   $('#updateEntryDate').append(option);
    	   
       });
       
/**
* On change event of date list it will populate information from pre populate list  
*/
       
       $('#updateEntryDate').on('change', function(){
    	   
    	   if(isNaN(parseInt($(this).val()))){
    		   alert(requestObject.formMessage.error['DateQuery']);
    		   requestObject.operationName=null;
    		   return false;
    	   }
    	   requestObject.operationName=requestObject.operationType.UPDATE;
    	   var selectId= parseInt($(this).val());
    	   $.each(requestObject.responseData, function(index, value){
    		   if(value.id === selectId){
    			   $('#RateEntry-FormBody :input[type=text]').each(function(index,data){
    	    		   $(data).val(value[($(data).attr('name'))]);
    	    	   });
    		   }
    	   });
       });
      
/**
* It will reset all the data .
*/
       
        $('#RateEntry #cancel').on('click', function(){
    	   $('#RateEntry #updateDateDiv').hide();
    	   $('#RateEntry #entryDateDiv').show();
    	   requestObject.operationName=requestObject.operationType.SAVE;
       })
  
       
/***********************************************************************************************************************/       
//*****************************              Department Master                   ***************************************
/**********************************************************************************************************************/       

	   	$('#departmentMaster #submit').on('click', function(){
	   	   $('#departmentMaster #updateDeptDiv').hide();
    	   $('#departmentMaster #inputDeptDiv').show();
	   		   
	   		 var json={};
	    	   
	    	   if(requestObject.operationName === requestObject.operationType.UPDATE){
	    		   json['id']=parseInt($('#departmentMaster #updateDeptCode').val());
	    		   json[$('#departmentMaster #updateDeptCode').attr('name')]=$('#departmentMaster #updateDeptCode option:selected').html();
	    	   } else if(requestObject.operationName === requestObject.operationType.SAVE){
	    		   var deptCode = parseInt($('#departmentMaster #insertDeptCode').val());
	    		   if(isNaN(deptCode)){
	    			   alert(requestObject.formMessage.error['DeptCode'])
	    			   return false;
	    		   }
	        	   json[$('#departmentMaster #insertDeptCode').attr('name')]=$('#departmentMaster #insertDeptCode').val();
	    	   } else{
	    		   alert(requestObject.formMessage.error['Operation'])
	    	   }
	   		   
	    	   $('#FormDepartmentMaster :input[type=text],select').each(function(index,data){
	    		   if($(data).attr('name') !== 'deptCode'){
	    			   json[$(data).attr('name')]=$(data).val();
	    		   }
	    	   })
	    	   
	           console.log(json);
	           var payload = requestObject.call(requestObject.methodType.POST, requestObject.appURL.DepartmentURL[requestObject.operationName], JSON.stringify(json))
	           console.log(payload);
	           $('#departmentMaster form')[0].reset();
	    	   $('#updateDeptCode option').remove();
	   		   
	   		});
    
/**
* The action for query is to search the rate in database and populate the Date List Field
*/
       
       $('#departmentMaster #query').on('click', function(){
    	   requestObject.operationName=requestObject.operationType.QUERY;
    	   $('#departmentMaster #updateDeptDiv').show();
    	   $('#departmentMaster #inputDeptDiv').hide();
    	   $('#departmentMaster form')[0].reset();
    	   $('#departmentMaster #updateDeptCode option').remove();
    	   	
    	   var payload = requestObject.call(requestObject.methodType.GET, 
    			   							requestObject.appURL.DepartmentURL[requestObject.operationName],
    			   							"");
    	   var option = '';
    	   option +='<option value="">select</option>'
    	   $.each(payload, function(index, value){
    		   option += '<option value="'+ value.id + '">' + value.deptCode + '</option>';
    	   });
    	   $('#departmentMaster #updateDeptCode').append(option);
    	   
       });
        
/**
* On change event of date list it will populate information from pre populate list  
*/
       
       $('#departmentMaster #updateDeptCode').on('change', function(){
    	   
    	   if(isNaN(parseInt($(this).val()))){
    		   alert(requestObject.formMessage.error['DateQuery']);
    		   requestObject.operationName=null;
    		   return false;
    	   }
    	   requestObject.operationName=requestObject.operationType.UPDATE;
    	   var selectId= parseInt($(this).val());
    	   $.each(requestObject.responseData, function(index, value){
    		   if(value.id === selectId){
    			   $('#departmentMaster :input[type=text],select').each(function(index,data){
    				   if($(data).attr('name') !== 'deptCode'){
    					   $(data).val(value[($(data).attr('name'))]);
    				   }
    	    	   });
    		   }
    	   });
       });
       
       
/**
* It will reset all the data .
*/       
       
       $('#departmentMaster #cancel').on('click', function(){
    	   $('#departmentMaster #updateDeptDiv').hide();
    	   $('#departmentMaster #inputDeptDiv').show();
	   		   requestObject.operationName=requestObject.operationType.SAVE;
	   		})
       
    });





    
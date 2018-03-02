$(document).ready(function(){
	
	// Onload call methods 
	if(requestObject.activePage === requestObject.pageNameList.DailyHand){
		loadDepartmentDatails('#FormDailyHands #deptCode','P');
		loadProductionDetails('#FormDailyHands #production', $('#FormDailyHands #entryDate').val());
	} else if(requestObject.activePage === requestObject.pageNameList.SingleHand){
		loadDepartmentDatails('#FormSingleHands #deptCode','S');
		loadProductionDetails('#FormSingleHands #production', $('#FormSingleHands #entryDate').val());
	}
	
	
	function loadDepartmentDatails(element, category){
 	   var payload = requestObject.call(requestObject.methodType.GET, 
						requestObject.appURL.DepartmentURL[requestObject.operationType.QUERY]+"?category="+category,
						"");
 	   
 	   var option = null;
 	   $(element).empty();
 	   $.each(payload, function(index, value){
 		   option += '<option value="'+ value.id + '">' + value.description +'('+value.deptCode+')' + '</option>';
 	   });
 	   $(element).append(option);
 	   console.log("loadDepartmentDatails");
    }
	
	function loadProductionDetails(element, date){
	 	   var payload = requestObject.call(requestObject.methodType.GET, 
							requestObject.appURL.DailyHand['ProductionData']+"?date="+date,
							"");
	 	   
	 	  $(element).val(payload.prodVal);
	 	 console.log("loadProductionDetails");
	    }
	
	function updateButton(element, operationName){
			$(element).html(operationName)
    }
	
	
/***********************************************************************************************************************/       
//*****************************             Single Hands Entry Form                 ***************************************
/**********************************************************************************************************************/
	
	$("#FormSingleHands .number").on("change blur keyup", function(e){
		   obj = $(this)
	        
	        try{
	            if(isNaN(obj.val())) throw "Not a number";
	        } catch(err){
	            obj.addClass("is-invalid")
	            obj.trigger("focus");
	            return false;
	        }
	        obj.removeClass("is-invalid")
	   });
	
	$("#FormSingleHands .number").on("focus",function(e){
        $(this).select();
    });
	
	$("#FormSingleHands #submit").on("click", function(){
        validateSingleHandsFormSubmit(this)
   });
	
	function validateSingleHandsFormSubmit(obj){
		
	   var json={};
	   var prod = $('#FormSingleHands #production');
	   var date = $('#FormSingleHands #entryDate');
	   date.removeClass("is-invalid");
	   prod.removeClass("is-invalid");
	   
  	   try{
  		   if(isNaN(prod.val()) || prod.val() ==='') throw requestObject.formMessage.error['ProductionData'];
  	   } catch(err){
  		   alert(err);
			   prod.addClass("is-invalid");
			   prod.trigger("focus");
			   return false;
  	   }
  	   
  	 try{
		   if(date.val() ==='') throw requestObject.formMessage.error['Date'];
	   } catch(err){
		   alert(err);
		   date.addClass("is-invalid");
		   date.trigger("focus");
			   return false;
	   }
	   
		   $('#FormSingleHands :input[type=text],select').each(function(index,data){
			   obj = $(data);
			   json[obj.attr('name')]=obj.val();	
		   });
			   
		   if(requestObject.operationName === requestObject.operationType.SAVE){
			   var payload = requestObject.call(requestObject.methodType.POST, requestObject.appURL.SingleHand[requestObject.operationName], JSON.stringify(json))
		   }else if(requestObject.operationName === requestObject.operationType.UPDATE){
			   var payload = requestObject.call(requestObject.methodType.POST, requestObject.appURL.SingleHand[requestObject.operationName], JSON.stringify(json))
			   requestObject.operationName = requestObject.operationType.SAVE
		   } else{
			   alert(requestObject.formMessage.error['Operation'])
		   }
		   
		   $('#FormSingleHands').trigger('reset');
		   setDate();
		   loadDepartmentDatails('#FormSingleHands #deptCode','S');
		   loadProductionDetails('#FormSingleHands #production', $('#FormSingleHands #entryDate').val());
		   updateButton('#FormSingleHands #submit',requestObject.operationName);
		   console.log("validateSingleHandsFormSubmit");
	   };
		
	   
/**
* The action for query is to search the rate in database and populate the Date List Field
*/
           $('#FormSingleHands #query').on('click', function(){onUpdateSingleHand();
           console.log("#FormSingleHands #query");});
           
/**
 *  On department change we need to chnage the update data
 * 
 */
       $('#FormSingleHands #deptCode').on('change', function(){
    	  if(requestObject.operationName === requestObject.operationType.UPDATE){
    		  onUpdateSingleHand();
    		  console.log("#FormSingleHands #deptCode");
    		}});
/**
* On date change call the production data.
*/
	   $('#FormSingleHands #entryDate').on('change', function(){
		   loadProductionDetails('#FormSingleHands #production', $('#FormSingleHands #entryDate').val());
		   console.log("#FormSingleHands #entryDate");
	   });
       
/**
 * On update function 
 * @returns
 */       
       function onUpdateSingleHand(){
    	   requestObject.operationName=requestObject.operationType.QUERY;
    	   var json={};
    	   var date = $('#FormSingleHands #entryDate');
    	   date.removeClass("is-invalid");
	       	try{
	 		   if(date.val() ==='') throw requestObject.formMessage.error['Date'];
	 	   } catch(err){
	 		   alert(err);
	 		   date.addClass("is-invalid");
	 		   date.trigger("focus");
	 			   return false;
	 	   }
	 	   
	 	  
	 	   $('#FormSingleHands :input[type=text],select').each(function(index,data){
		   obj = $(data);
		   json[obj.attr('name')]=obj.val();	
	   });
    	   
	   var payload = requestObject.call(requestObject.methodType.POST, 
			   							requestObject.appURL.SingleHand[requestObject.operationName],
			   							JSON.stringify(json));
	 	  	
	 	  if(payload !== null){
	 		    requestObject.operationName=requestObject.operationType.UPDATE;
		 		var obj = $('#FormSingleHands #handValue')
		 		obj.val(payload[(obj.attr('name'))]);
		 		updateButton('#FormSingleHands #submit',requestObject.operationName);
	 	  }
	 	 console.log("onUpdateSingleHand");
       }
  	   
/**
*  On cancel event fire the production details and set date.
*/        
       
       $('#FormSingleHands #cancel').on('click', function(){
      	 requestObject.operationName=requestObject.operationType.SAVE;
      	 $('#FormSingleHands').trigger('reset');
      	   setDate();
      	   	loadDepartmentDatails('#FormSingleHands #deptCode','S');
      	 	loadProductionDetails('#FormSingleHands #production', $('#FormSingleHands #entryDate').val());
      	   updateButton('#FormSingleHands #submit',requestObject.operationName);
      	 console.log("#FormSingleHands #cancel");
       });
             
       
       
       
       
/***********************************************************************************************************************/       
//*****************************              Hands Entry Form                 ***************************************
/**********************************************************************************************************************/
	
	   $("#FormDailyHands #production").on("change blur keyup", function(e){
		   obj = $(this)
	        
	        try{
	            if(isNaN(obj.val())) throw "Not a number";
	        } catch(err){
	            obj.addClass("is-invalid")
	            obj.trigger("focus");
	            return false;
	        }
	        obj.removeClass("is-invalid")
	   });
	
	   $("#FormDailyHands #production").on("focus",function(e){
	        $(this).select();
	    });
	   
       $("#FormDailyHands #DailyHands-FormBody .form-control").on("change blur keyup",function(e){
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

       $("#FormDailyHands #DailyHands-FormBody .form-control").on("focus",function(e){
        $(this).select();
       });

       $("#FormDailyHands #submit").on("click", function(){
            validateShiftHandsFormSubmit(this)
       });

       function validateShiftHandsFormSubmit(obj){
    	   
    	   var json={};
    	   var listNotRequired = ['unit', 'category']
    	   var prod = $('#FormDailyHands #production');
    	   var date = $('#FormDailyHands #entryDate');
    	   try{
    		   if(isNaN(prod.val()) || prod.val() ==='') throw requestObject.formMessage.error['ProductionData'];
    	   } catch(err){
    		   alert(err);
			   prod.addClass("is-invalid");
			   prod.trigger("focus");
			   return false;
    	   }
    	   
    	   try{
    		   if(date.val() ==='') throw requestObject.formMessage.error['Date'];
    	   } catch(err){
    		   alert(err);
    		   date.addClass("is-invalid");
    		   date.trigger("focus");
    			   return false;
    	   }
    	   
    	   $('#FormDailyHands #DailyHands-FormBody	 :input[type=text]').each(function(index,data){
    		   
    		   if($(data).attr('name') !== undefined){
    			   json[$(data).attr('name')]=$(data).val();	
    		   	}
	    	   });
    	   $('#FormDailyHands #DailyHandsFormHeader	:input[type=text],select').each(function(index,data){
    		   obj = $(data);
    		   if(listNotRequired.indexOf(obj.attr('name')) === -1){ // Not in
    			   json[obj.attr('name')]=obj.val();	
    		   }
    	   })
    	   
    	   
    	   if(requestObject.operationName === requestObject.operationType.SAVE){
    		   var payload = requestObject.call(requestObject.methodType.POST, requestObject.appURL.DailyHand[requestObject.operationName], JSON.stringify(json))
    	   }else if(requestObject.operationName === requestObject.operationType.UPDATE){
    		   var payload = requestObject.call(requestObject.methodType.POST, requestObject.appURL.DailyHand[requestObject.operationName], JSON.stringify(json))
    		   requestObject.operationName = requestObject.operationType.SAVE
    	   } else{
    		   alert(requestObject.formMessage.error['Operation'])
    	   }
    	   
    	   $('#FormDailyHands').trigger('reset');
    	   setDate();
    	   loadDepartmentDatails('#FormDailyHands #deptCode','P');
   		   //loadProductionDetails('#FormDailyHands #production', $('#FormDailyHands #entryDate').val());
    	   updateButton('#FormDailyHands #submit',requestObject.operationName);
    	   console.log("validateShiftHandsFormSubmit");
       }
      
       
   /**
   * The action for query is to search the rate in database and populate the Date List Field
   */
          
          $('#FormDailyHands #query').on('click', function(){onUpdateDailyHand();
          console.log("#FormDailyHands #query");});
       
  /**
  * On date change call the production data.
  */
  	   $('#FormDailyHands #entryDate').on('change', function(){
  		   loadProductionDetails('#FormDailyHands #production', $('#FormDailyHands #entryDate').val());
  		   console.log("#FormDailyHands #entryDate");
  	   });
  /**
  * On change event of date list it will populate information from pre populate list  
  */
         
         $('#FormDailyHands #deptCode').on('change', function(){
      	   
      	   if(isNaN(parseInt($(this).val()))){
      		   alert(requestObject.formMessage.error['DepartmentQuery']);
      		   requestObject.operationName=null;
      		   return false;
      	   }
	      	 var payload = requestObject.call(requestObject.methodType.GET, 
						requestObject.appURL.DepartmentURL[requestObject.operationType.QUERY]+"?category=P",
						"");
      	   var selectId= parseInt($(this).val());
      	   var list=['production','deptCode','entryDate','entryType'];
      	   $.each(payload, function(index, value){
      		   if(value.id === selectId){
      			   $('#DailyHandsFormHeader	 :input[type=text],select').each(function(index,data){
      				   if(list.indexOf($(data).attr('name')) === -1 ){
      					   $(data).val(value[($(data).attr('name'))]);
      				   }
      	    	   });
      		   }
      	   });
      	   if(requestObject.operationName===requestObject.operationType.UPDATE){
      		 onUpdateDailyHand();
      	   }
      	 console.log("#FormDailyHands #deptCode");
         });
         
 /**
  * On date change call the production data.
  */
         $('#FormDailyHands #entryDate').on('change', function(){
        	 loadProductionDetails('#FormDailyHands #production', $('#FormDailyHands #entryDate').val());
        	 console.log("#FormDailyHands #entryDate");
         });
         
         
         
 /**
  * On update the request 
  */
       
       function onUpdateDailyHand(){
    	   requestObject.operationName=requestObject.operationType.QUERY;
       	   var json={};
       	   var listNotRequired = ['unit', 'category']
       	   var date = $('#FormDailyHands #entryDate');
       	   
	       	try{
	 		   if(date.val() ==='') throw requestObject.formMessage.error['Date'];
	 	   } catch(err){
	 		   alert(err);
	 		   date.addClass("is-invalid");
	 		   date.trigger("focus");
	 			   return false;
	 	   }
       	   
	 	  $('#FormDailyHands #DailyHandsFormHeader	:input[type=text],select').each(function(index,data){
   		   obj = $(data);
	   		   if(listNotRequired.indexOf(obj.attr('name')) === -1){ // Not in
	   			   json[obj.attr('name')]=obj.val();	
	   		   	}
	 	  })
       	   
	 	  
       	   
       	   var payload = requestObject.call(requestObject.methodType.POST, 
       			   							requestObject.appURL.DailyHand[requestObject.operationName],
       			   							JSON.stringify(json));
	 	 requestObject.operationName=requestObject.operationType.SAVE;
	 	  if(payload !== null){
	 		    requestObject.operationName=requestObject.operationType.UPDATE;
		 		$('#FormDailyHands #DailyHands-FormBody :input[type=text]').each(function(index,data){
		    		   $(data).val(payload[($(data).attr('name'))]);
		    		   idVal = $(this).attr("id");
		               rowNum = idVal.substring(0,4);
		               temp=0;
		               for(i=1;i<=3;i++){
		                       temp=temp+parseInt($("#"+rowNum+i).val())
		               }
		               $("#"+rowNum+4).val(temp);
		    	   });
		 		
	 	  }
	 	 updateButton('#FormDailyHands #submit',requestObject.operationName);
	 	 console.log("onUpdateDailyHand");
       }
         
 /**
  *  On cancel event fire the production details and set date.
  */        
         
         $('#FormDailyHands #cancel').on('click', function(){
        	 requestObject.operationName=requestObject.operationType.SAVE;
        	 $('#FormDailyHands').trigger('reset');
        	   setDate();
        	   loadDepartmentDatails('#FormDailyHands #deptCode','P');
       		   loadProductionDetails('#FormDailyHands #production', $('#FormDailyHands #entryDate').val());
        	   updateButton('#FormDailyHands #submit',requestObject.operationName);
        	   console.log("#FormDailyHands #cancel");
         });
         
       
         
     
       

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
    	   
    	   $('#RateEntry-FormBody :input[type=text]').each(function(index,data){
    		   json[$(data).attr('name')]=$(data).val();
    	   })
           var payload = requestObject.call(requestObject.methodType.POST, requestObject.appURL.RateEntry[requestObject.operationName], JSON.stringify(json))
           $('#RateEntry form')[0].reset();
    	   $('#updateEntryDate option').remove();
    	   setDate();
    	   updateButton('#RateEntry #submit',requestObject.operationName);
    	   console.log("#RateEntry #submit");
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
    	   option +='<option value="">Select</option>'
    	   $.each(payload, function(index, value){
    		   var date = new Date(value.entryDate);
    		   option += '<option value="'+ value.id + '">' + date.getDate()+'/'+(parseInt(date.getMonth())+1)+'/'+date.getFullYear() + '</option>';
    	   });
    	   $('#updateEntryDate').append(option);
    	   console.log("#RateEntry #query");
    	   
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
    	   updateButton('#RateEntry #submit',requestObject.operationName);
    	   console.log("#updateEntryDate");
       });
      
/**
* It will reset all the data .
*/
       
        $('#RateEntry #cancel').on('click', function(){
    	   $('#RateEntry #updateDateDiv').hide();
    	   $('#RateEntry #entryDateDiv').show();
    	   requestObject.operationName=requestObject.operationType.SAVE;
    	   updateButton('#RateEntry #submit',requestObject.operationName);
    	   console.log("#RateEntry #cancel");
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
	    		   requestObject.operationName = requestObject.operationType.UPDATE
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
	    	   
	           var payload = requestObject.call(requestObject.methodType.POST, requestObject.appURL.DepartmentURL[requestObject.operationName], JSON.stringify(json))
	           $('#departmentMaster').trigger('reset');
	    	   $('#updateDeptCode option').remove();
	    	   updateButton('#departmentMaster #submit',requestObject.operationName);
	    	   console.log("#departmentMaster #submit");
	   		   
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
    	   option +='<option value="">Select</option>'
    	   $.each(payload, function(index, value){
    		   option += '<option value="'+ value.id + '">' + value.deptCode + '</option>';
    	   });
    	   $('#departmentMaster #updateDeptCode').append(option);
    	   console.log("#departmentMaster #query");
       });
        
/**
* On change event of date list it will populate information from pre populate list  
*/
       
       $('#departmentMaster #updateDeptCode').on('change', function(){
    	   
    	   if(isNaN(parseInt($(this).val()))){
    		   alert(requestObject.formMessage.error['DepartmentQuery']);
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
    	   updateButton('#departmentMaster #submit',requestObject.operationName);
    	   console.log("#departmentMaster #updateDeptCode");
       });
       
       
/**
* It will reset all the data .
*/       
       
       $('#departmentMaster #cancel').on('click', function(){
    	   $('#departmentMaster #updateDeptDiv').hide();
    	   $('#departmentMaster #inputDeptDiv').show();
	   		   requestObject.operationName=requestObject.operationType.SAVE;
	   		updateButton('#departmentMaster #submit',requestObject.operationName);
	   		console.log("#departmentMaster #cancel");
	   		})
	   		
/***********************************************************************************************************************/       
//*****************************             View Hands Details                   ***************************************
/**********************************************************************************************************************/
	
   		$('#viewHands #search').on('click', function(){
   			
     	   $('#viewHands #Excelreport').hide();
   			var date = $('#viewHands #entryDate').val();
   			if(date === ''){
   				alert(requestObject.formMessage.error['Date']);
   				return false;
   			}
   			
   			var payload = requestObject.call(requestObject.methodType.GET, 
					requestObject.appURL.DailyHand['ProductionData']+"?date="+date,
					"");
	   
   			$('#viewHands #production').html(payload.prodVal);
   			
   			var dailyHand = requestObject.call(requestObject.methodType.GET, 
					requestObject.appURL.DailyHand['QueryAll']+"?date="+date,
					"");
   			var singleHand = requestObject.call(requestObject.methodType.GET, 
					requestObject.appURL.SingleHand['QueryAll']+"?date="+date,
					"");
   			
   			finalList=[];
   			
   			$.each(dailyHand, function(index, data){
   				var dataList={"deptDesc":"","permanent":0,"specialBadly":0,"badly":0,"semiSkilled":0,"learner":0,"newEntrance":0,
 						  "outsider":0,"otherMill":0,"voucherRet":0, "total":0}
   				totalval=0;
   				$.each(data, function(index1,value){
   					if(dataList[index1.substring(0,index1.length-1)] !== undefined){
   						dataList[index1.substring(0,index1.length-1)]=dataList[index1.substring(0,index1.length-1)]+value;
   						totalval=totalval+value;
   					} else if(index1 === "deptDesc"){
   						dataList[index1.substring(0,index1.length)] = value;
   					}
   					
   				});
   				dataList["total"]=totalval;
   				finalList.push(dataList);
   			});
   			$.each(singleHand, function(index, data){
   				var dataList={"deptDesc":"","permanent":"","specialBadly":"","badly":"","learner":"","semiSkilled":"","newEntrance":"",
 						  "outsider":"","otherMill":"","voucherRet":"", "total":0}
   				dataList["deptDesc"]=data["deptDesc"];
   				dataList["total"]=data["handValue"];
   				finalList.push(dataList);
   			});
   			
   			if(dailyHand !== null || singleHand !==null){
   				$('#viewHands #Excelreport').show();
   			}
   			
   			var viewTable =$('#viewHands #tableView');
   			viewTable.empty();
   			$.each(finalList, function(index, data){
   				var rowDetails ="<tr>";
   				totalVal=0;
   				$.each(data, function(index1, value){
   					rowDetails=rowDetails+"<td>"+value+"</td>";
   				})
   				rowDetails=rowDetails+"</tr>";
   				viewTable.append(rowDetails);
   				
   			});
   			console.log("#viewHands #search");
   			
   		});
	   		
       $('#viewHands #Excelreport').on('click', function(){
    	   
    	   var date = $('#viewHands #entryDate').val();
  			if(date === ''){
  				alert(requestObject.formMessage.error['Date']);
  				return false;
  			}
  			console.log("#viewHands #Excelreport");
  			window.location.href = requestObject.appURL.Report['DailyHands']+"?date="+date;
       })
       
    }); // End of the document ready 




    
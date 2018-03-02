var requestObject = {
                     formRegex: {
                                  'name':/^([a-zA-Z0-9])+$/,
                                  'email':/^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/,
                                  'contact':/^([0-9]){10}$/,
                                  'dateformat':/^([0][0-9]{1}|[1][0-9]{1})\/([0,1,2][0-9]{1}|[3][0-1]{1})\/([19,20]{1}[0-9]{2})$/
                     },
                     formMessage:{
                    	 error:{
                    		 'Date': 'Date cannot be blank',
                    		 'DateQuery': 'Please select the correct date',
                    		 'DeptCode':'Department code should be number only',
                    		 'Operation':'Operation is wrong',
                    		 'DepartmentQuery':'Please select the correct dept',
                    		 'ProductionData':'Please provide valid production data'
                    	 },
                    	 success:{
                    		 'success':'Saved Data'
                    	 }
                     },
                     appURL:{
                     	RateEntry:{
                     		'Save':'/rateEntry/save.json',
                     		'Update':'/rateEntry/update.json',
                     		'QueryAll':'/rateEntry/queryAll.json'
                     	},
                     	DepartmentURL:{
                     		'Save':'/departmentEntry/save.json',
                     		'Update':'/departmentEntry/update.json',
                     		'QueryAll':'/departmentEntry/queryAll.json'
                     	},	
                     	DailyHand:{
                     		'Save':'/dailyHands/save.json',
                     		'Update':'/dailyHands/update.json',
                     		'QueryAll':'/dailyHands/query.json',
                     		'ProductionData':'/dailyHands/production.json'
                     	},	
                     	SingleHand:{
                     		'Save':'/singleHands/save.json',
                     		'Update':'/singleHands/update.json',
                     		'QueryAll':'/singleHands/query.json'
                     	},
                     	Report:{
                     		'DailyHands':'/report/dailyHands.json',
                     	}	
                     },
                     activePage:null,
                     pageNameList:{
                    	 Department:"Department",
                    	 DailyHand:"DailyHand",
                    	 SingleHand:"SingleHand",
                         Rate:"Rate"
                     },
                     methodType:{
                    	 POST:'post',
                    	 GET:'get'
                     },
                     operationType:{
                    	 SAVE:'Save',
                    	 UPDATE:'Update',
                    	 QUERY:'QueryAll',
                    	 CANCEL:'cancel'
                     },                     
                     requestData:null,
                     operationName:null,
                     error:[],
                     init:function(requestData, error){
                           this.requestData = requestData;
                           this.error = error;
                     },
                    
                     getError:function (){
                           return this.error;
                     },
                    
                     getRequestData:function(){
                           return this.requestData;
                     },
                    
                     applyRegex:function(regexName, value){
                           return this.formRegex[regexName].test(value)
                     },
                     responseData:null,
                     call:function(methodType, appurl, jsonData){
                    	 var returnPayload="";
                    	 $.ajax({
                    		    url: appurl,
                    		    dataType: 'json',
                    		    type: methodType,
                    		    contentType: 'application/json',
                    		    data: jsonData,
                    		    async : false,
                    		    success: function( data, textStatus, jQxhr ){
                    		    	if(data.error !== null){
                    		    		alert(data.error);
                    		    		requestObject.responseData="";
                    		    		return false;
                    		    	}  else{
                                       // alert(data.success);
                                        requestObject.responseData =data.payload;
                                        return true;
                                 }
                    		    },
                    		    error: function( jqXhr, textStatus, errorThrown ){
                    		    	if(jqXhr.status === 400){
                    		    		var msg;
                    		    		$.each(jqXhr.responseJSON.error, function(index,val){
                    		    			msg=val+"\n";
                    		    		})
                    		    		alert(jqXhr.status + ":"+ msg);
                    		    	} else{
                    		    		alert(jqXhr.status + ": Please contact system administrator");
                    		    	}
                    		    	
                    		    	requestObject.responseData=null;
                    		    }
                    		});
                    	 return requestObject.responseData;
                     }
       };

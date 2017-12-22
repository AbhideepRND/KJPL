var requestObject = {
                     formRegex: {
                                  'name':/^([a-zA-Z0-9])+$/,
                                  'email':/^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/,
                                  'contact':/^([0-9]){10}$/,
                                  'dateformat':/^([0][0-9]{1}|[1][0-9]{1})\/([0,1,2][0-9]{1}|[3][0-1]{1})\/([19,20]{1}[0-9]{2})$/
                     },
                     formMessage:{
                    	 error:{
                    		 'Date': 'Date cannot be blank'
                    	 },
                    	 success:{
                    		 'success':'Saved Data'
                    	 }
                     },
                     appURL:{
                     	RateEntry:{
                     		'save':'/server/rateEntry/save.json',
                     		'update':'/server/rateEntry/update.json',
                     	}	
                     },
                     requestData:null,
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
                     call:function(methodType, appurl, jsonData){
                    	 $.ajax({
                    		    url: appurl,
                    		    dataType: 'json',
                    		    type: methodType,
                    		    contentType: 'application/json',
                    		    data: jsonData,
                    		    processData: false,
                    		    success: function( data, textStatus, jQxhr ){
                    		        $('#response pre').html( JSON.stringify( data ) );
                    		    },
                    		    error: function( jqXhr, textStatus, errorThrown ){
                    		        console.log( errorThrown );
                    		    }
                    		});
                     }
                     
       };

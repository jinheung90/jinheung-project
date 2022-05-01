
import './App.css';
import axios from 'axios';
import ReactDOM from 'react-dom'
import React,{useEffect, useState} from 'react';


import { Stomp } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

var configuration = {
  iceServers : [ {
      url : "turn:3.38.236.115:3478?transport=udp",
      credential: 'audiviceSignal',
      username: 'audivice'
  } ]
};

function App() {
  useEffect(() => {

    const sockjs = document.createElement("sockjs");
    sockjs.src = "https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js";
    document.head.appendChild(sockjs);
    const jquery = document.createElement("script");
    jquery.src = "https://code.jquery.com/jquery-1.12.4.min.js";
    document.head.appendChild(jquery);
    const iamport = document.createElement("script");
    iamport.src = "https://cdn.iamport.kr/js/iamport.payment-1.2.0.js";
    document.head.appendChild(iamport);

  }, []);
  
const constraints = {
  video: false,
  audio: true
}

  const [image, setImage] =useState(null); 
    const handleFileInput = (e) => {
        setImage(e.target.files[0]);
        console.log(e.target.files[0]);
      }
    // mentee 42 mentor 8
      let test = null;
       let  handlePost = async () => {
        const sockjs = new SockJS("https://socket.audivice.com/signal")
        // const sockjs = new SockJS("http://localhost:8080/signal")
        test =  Stomp.over(sockjs)
          new Promise(() => test.connect(
            {
              Authorization : "testMentor"
              ,"Access-Control-Allow-Origin" : "*"
            }, () => {
            // let configuration = null;
            let peerConnection = new RTCPeerConnection(configuration);
            var dataChannel = peerConnection.createDataChannel("audivice", { reliable: true });
            console.log(peerConnection);
            dataChannel.onopen = (e) => {
              console.log(e);
            }

            dataChannel.onerror = (e) => {
              console.log(e);
            }
            dataChannel.onmessage = (a) => {
              console.log(a.data);
            }
            
            peerConnection.ondatachannel = (a) => {
              dataChannel = a.channel;
            }

            peerConnection.onicecandidate = (ev) => {
              if(ev.candidate) {
                test.send("/pub/mentoring/candidate", {              reservationId : 147,}, JSON.stringify(ev.candidate))
              }
            }

            test.subscribe("/user/sub/mentoring/candidate", (e) => {
              console.log(e);
              peerConnection.addIceCandidate(new RTCIceCandidate(JSON.parse(e.body)));
            })

            test.subscribe("/user/sub/mentoring/candidate", (e) => {
              console.log(e);
              peerConnection.addIceCandidate(new RTCIceCandidate(JSON.parse(e.body)));
            })

            test.subscribe("/user/sub/mentoring/start", (e) => {
              console.log(e)
              if(e.body === "mentor") {
                peerConnection.createOffer().then((offer) => {
                  test.send("/pub/mentoring/offer", { reservationId : 147},
                  JSON.stringify(offer))
                  return offer;
                }).then((offer) => peerConnection.setLocalDescription(offer))
               
              }
            } ,{})
            
            test.subscribe("/user/sub/mentoring/answer", (e) => {
              console.log(e)
              // remoteAnswer
              
              peerConnection.setRemoteDescription(new RTCSessionDescription(JSON.parse(e.body)))
            } ,{})

            test.subscribe("/user/sub/mentoring/offer", async (e) => {
              // remoteOffer 
              // send answer
              console.log(e)
              await peerConnection.setRemoteDescription(new RTCSessionDescription(JSON.parse(e.body)))
              await peerConnection.createAnswer().then((answer) => {
                peerConnection.setLocalDescription(answer)
                test2.send("/pub/mentoring/answer", { reservationId : 147},
                    
                  JSON.stringify(answer))
                  return answer;
              })
            } ,{})

            test.subscribe("/user/sub/mentoring/notification", (e) => {
              console.log(e)
    
            } ,{})


            
            test.send("/pub/mentoring/init", {
              reservationId : 147,
              Authorization : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwidXNlcl9yb2xlX25hbWUiOiJST0xFX01FTlRPUiIsInVzZXJfcm9sZV92YWx1ZSI6MiwiQXV0aG9yaXRpZXMiOiJST0xFX1VTRVIsUk9MRV9NRU5URUUsUk9MRV9NRU5UT1IiLCJleHAiOjE2NDk1ODAxMTV9.YL2pQkQEearGH_LPEeuY3sDpOZ8eOR2ziJyWJwqA7ZBlAn78pW3n7Yys4-6OTksHQE1TRnIqwhQEngQS5QH_iQ"}
            ,
            "empty")
            return peerConnection;
         }))
        }
      
     //102 8 82 8
    let test2 = null;
     const handlePos2t = () => {
      // const sockjs = new SockJS("http://3.38.236.115/signal")
      const sockjs = new SockJS("https://socket.audivice.com/signal")
      // const sockjs = new SockJS("http://localhost:8080/signal")
      //
      test2 =  Stomp.over(sockjs)
  
      new Promise(() => test2.connect({Authorization : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJ1c2VyX3JvbGVfbmFtZSI6IlJPTEVfTUVOVEVFIiwidXNlcl9yb2xlX3ZhbHVlIjo0LCJBdXRob3JpdGllcyI6IlJPTEVfVVNFUixST0xFX01FTlRPUixST0xFX01FTlRFRSIsImV4cCI6MTY0OTU4MDM5N30.9LduU7Yg1ndQp4pQ1p-YcRvxH4UMXNPBWtw_msQk0EsJaEFs0rR2q_8Vz6bnjROZ6Hj7XjpqA78d3LoaeyjqBg"}, () => {
        let configuration = null;
        let peerConnection = new RTCPeerConnection(configuration);
        var dataChannel = peerConnection.createDataChannel("audivice", { reliable: true });
        console.log(peerConnection);
        dataChannel.onopen = (e) => {
          console.log(e);
        }

        dataChannel.onerror = (e) => {
          console.log(e);
        }
        peerConnection.onicecandidate = (ev) => {
          if(ev.candidate) {
            test2.send("/pub/mentoring/candidate", {              reservationId : 147}, JSON.stringify(ev.candidate))
          }
        }

        test2.subscribe("/user/sub/mentoring/candidate", (e) => {
          console.log(e);
          peerConnection.addIceCandidate(new RTCIceCandidate(JSON.parse(e.body)));
        })

        test2.subscribe("/user/sub/mentoring/start", (e) => {
          console.log(e)
          if(e.body === "mentor") {
            peerConnection.createOffer().then((offer) => {
              test2.send("/pub/mentoring/offer", {              reservationId : 147},
              JSON.stringify(offer))
              return offer;
            }).then((offer) => peerConnection.setLocalDescription(offer))
           
          }
        } ,{})
        
        test2.subscribe("/user/sub/mentoring/answer", (e) => {
          console.log(e)
          // remoteAnswer
          peerConnection.setRemoteDescription(new RTCSessionDescription(JSON.parse(e.body)))
        } ,{})

        test2.subscribe("/user/sub/mentoring/offer", async (e) => {
          // remoteOffer 
          // send answer
          
          console.log(e)
          await peerConnection.setRemoteDescription(new RTCSessionDescription(JSON.parse(e.body)))
          await peerConnection.createAnswer().then((answer) => {
            peerConnection.setLocalDescription(answer)
            test2.send("/pub/mentoring/answer", {reservationId : 147},
              JSON.stringify(answer))
              return answer;
          })
        } ,{})

        test2.subscribe("/user/sub/mentoring/notification", (e) => {
          console.log(e)

        } ,{})
        test2.send("/pub/mentoring/init", {
          reservationId : 147,
          Authorization :"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJ1c2VyX3JvbGVfbmFtZSI6IlJPTEVfTUVOVEVFIiwidXNlcl9yb2xlX3ZhbHVlIjo0LCJBdXRob3JpdGllcyI6IlJPTEVfVVNFUixST0xFX01FTlRPUixST0xFX01FTlRFRSIsImV4cCI6MTY0OTU4MDM5N30.9LduU7Yg1ndQp4pQ1p-YcRvxH4UMXNPBWtw_msQk0EsJaEFs0rR2q_8Vz6bnjROZ6Hj7XjpqA78d3LoaeyjqBg"
          
        }
        ,"empty")
     }))
    }
  
    const testsend = () => {
      // test2.send("/pub/mentoring/user/connection/state", {}
      //  ,"new")
      test.send("/pub/mentoring/quit", {}, "quit")
    }

    const getSessionIds = () => {
      axios.get("http://3.38.236.115/message").then(a => console.log(a))
    }

    const testConnection = () => {
      // const sockjs = new SockJS("https:/1/socket.audivice.com/signal")
      const sockjs = new SockJS("http://localhost:8081/client")
      test =  Stomp.over(sockjs)
      test.connect({
        "Access-Control-Allow-Origin" : "*",
       Authorization : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjYiLCJ1c2VyX3JvbGVfbmFtZSI6IlJPTEVfTUVOVEVFIiwidXNlcl9yb2xlX3ZhbHVlIjo0LCJBdXRob3JpdGllcyI6IlJPTEVfVVNFUixST0xFX01FTlRPUixST0xFX01FTlRFRSIsImV4cCI6MTY0OTU4MDM5N30.9LduU7Yg1ndQp4pQ1p-YcRvxH4UMXNPBWtw_msQk0EsJaEFs0rR2q_8Vz6bnjROZ6Hj7XjpqA78d3LoaeyjqBg"}, () => {})

    }

    
    const testConnection2 = () => {

        const {IMP} = window

        IMP.init('imp42579206'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
        IMP.request_pay({
          pg: "inicis",
          pay_method: "card",
          merchant_uid : 'merchant_'+new Date().getTime(),
          name : '결제테스트',
          amount : 1400,
          buyer_email : 'iamport@siot.do',
          buyer_name : '구매자',
          buyer_tel : '010-1234-5678',
          buyer_addr : '서울특별시 강남구 삼성동',
          buyer_postcode : '123-456'
        }, function (rsp) { // callback
            axios.post("http://localhost:8081/payment/verify", {impUid : rsp.imp_uid})
        });

    }
  
    return (

    <div className="App">


        <button type="button" onClick={handlePost}>A</button>
        <button type="button" onClick={handlePos2t}>B</button>
        <button type="button" onClick={testsend}>C</button>
        <button type="button" onClick={getSessionIds}>C</button>
        <button type="button" onClick={testConnection}>d</button>
        <button type="button" onClick={testConnection2}>e</button>
    </div>
  );
}
export default App;

/*   

const onSuccess = async(response) => {
    console.log(response);
    const { googleId, profileObj : { email, name } } = response;
    console.log(response);

}

const onFailure = (error) => {
    console.log(error);
}
<GoogleLogin
         clientId='1032817085234-l9f0vo7hjec0s98gkchf7e9dv8earau6.apps.googleusercontent.com'
         responseType={"id_token"}
         onSuccess={result => onSuccess(result)}
         onFailure={result => onFailure(result)}
         cookiePolicy={'single_host_origin'}
      />   
*/


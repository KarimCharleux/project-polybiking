﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace PolyBiking.Proxy {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="Proxy.IProxyService")]
    public interface IProxyService {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetStationInfo", ReplyAction="http://tempuri.org/IProxyService/GetStationInfoResponse")]
        string GetStationInfo();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetStationInfo", ReplyAction="http://tempuri.org/IProxyService/GetStationInfoResponse")]
        System.Threading.Tasks.Task<string> GetStationInfoAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetRouteInfo", ReplyAction="http://tempuri.org/IProxyService/GetRouteInfoResponse")]
        string GetRouteInfo(double startLat, double startLng, double endLat, double endLng, string pathType);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetRouteInfo", ReplyAction="http://tempuri.org/IProxyService/GetRouteInfoResponse")]
        System.Threading.Tasks.Task<string> GetRouteInfoAsync(double startLat, double startLng, double endLat, double endLng, string pathType);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetAddressInfo", ReplyAction="http://tempuri.org/IProxyService/GetAddressInfoResponse")]
        string GetAddressInfo(string address);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetAddressInfo", ReplyAction="http://tempuri.org/IProxyService/GetAddressInfoResponse")]
        System.Threading.Tasks.Task<string> GetAddressInfoAsync(string address);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IProxyServiceChannel : PolyBiking.Proxy.IProxyService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class ProxyServiceClient : System.ServiceModel.ClientBase<PolyBiking.Proxy.IProxyService>, PolyBiking.Proxy.IProxyService {
        
        public ProxyServiceClient() {
        }
        
        public ProxyServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public ProxyServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ProxyServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ProxyServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public string GetStationInfo() {
            return base.Channel.GetStationInfo();
        }
        
        public System.Threading.Tasks.Task<string> GetStationInfoAsync() {
            return base.Channel.GetStationInfoAsync();
        }
        
        public string GetRouteInfo(double startLat, double startLng, double endLat, double endLng, string pathType) {
            return base.Channel.GetRouteInfo(startLat, startLng, endLat, endLng, pathType);
        }
        
        public System.Threading.Tasks.Task<string> GetRouteInfoAsync(double startLat, double startLng, double endLat, double endLng, string pathType) {
            return base.Channel.GetRouteInfoAsync(startLat, startLng, endLat, endLng, pathType);
        }
        
        public string GetAddressInfo(string address) {
            return base.Channel.GetAddressInfo(address);
        }
        
        public System.Threading.Tasks.Task<string> GetAddressInfoAsync(string address) {
            return base.Channel.GetAddressInfoAsync(address);
        }
    }
}
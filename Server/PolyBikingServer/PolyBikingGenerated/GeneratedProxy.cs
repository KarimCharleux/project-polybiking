﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Proxy_Cache
{
    using System.Runtime.Serialization;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Position", Namespace="http://schemas.datacontract.org/2004/07/Proxy_Cache")]
    public partial class Position : object, System.Runtime.Serialization.IExtensibleDataObject
    {
        
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        private double LatField;
        
        private double LngField;
        
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData
        {
            get
            {
                return this.extensionDataField;
            }
            set
            {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public double Lat
        {
            get
            {
                return this.LatField;
            }
            set
            {
                this.LatField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public double Lng
        {
            get
            {
                return this.LngField;
            }
            set
            {
                this.LngField = value;
            }
        }
    }
}


[System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
[System.ServiceModel.ServiceContractAttribute(ConfigurationName="IProxyService")]
public interface IProxyService
{
    
    [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetStationInfo", ReplyAction="http://tempuri.org/IProxyService/GetStationInfoResponse")]
    string GetStationInfo();
    
    [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetStationInfo", ReplyAction="http://tempuri.org/IProxyService/GetStationInfoResponse")]
    System.Threading.Tasks.Task<string> GetStationInfoAsync();
    
    [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetRouteInfo", ReplyAction="http://tempuri.org/IProxyService/GetRouteInfoResponse")]
    string GetRouteInfo(Proxy_Cache.Position start, Proxy_Cache.Position end);
    
    [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetRouteInfo", ReplyAction="http://tempuri.org/IProxyService/GetRouteInfoResponse")]
    System.Threading.Tasks.Task<string> GetRouteInfoAsync(Proxy_Cache.Position start, Proxy_Cache.Position end);
    
    [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetAddressInfo", ReplyAction="http://tempuri.org/IProxyService/GetAddressInfoResponse")]
    string GetAddressInfo(string address);
    
    [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetAddressInfo", ReplyAction="http://tempuri.org/IProxyService/GetAddressInfoResponse")]
    System.Threading.Tasks.Task<string> GetAddressInfoAsync(string address);
}

[System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
public interface IProxyServiceChannel : IProxyService, System.ServiceModel.IClientChannel
{
}

[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
public partial class ProxyServiceClient : System.ServiceModel.ClientBase<IProxyService>, IProxyService
{
    
    public ProxyServiceClient()
    {
    }
    
    public ProxyServiceClient(string endpointConfigurationName) : 
            base(endpointConfigurationName)
    {
    }
    
    public ProxyServiceClient(string endpointConfigurationName, string remoteAddress) : 
            base(endpointConfigurationName, remoteAddress)
    {
    }
    
    public ProxyServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
            base(endpointConfigurationName, remoteAddress)
    {
    }
    
    public ProxyServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
            base(binding, remoteAddress)
    {
    }
    
    public string GetStationInfo()
    {
        return base.Channel.GetStationInfo();
    }
    
    public System.Threading.Tasks.Task<string> GetStationInfoAsync()
    {
        return base.Channel.GetStationInfoAsync();
    }
    
    public string GetRouteInfo(Proxy_Cache.Position start, Proxy_Cache.Position end)
    {
        return base.Channel.GetRouteInfo(start, end);
    }
    
    public System.Threading.Tasks.Task<string> GetRouteInfoAsync(Proxy_Cache.Position start, Proxy_Cache.Position end)
    {
        return base.Channel.GetRouteInfoAsync(start, end);
    }
    
    public string GetAddressInfo(string address)
    {
        return base.Channel.GetAddressInfo(address);
    }
    
    public System.Threading.Tasks.Task<string> GetAddressInfoAsync(string address)
    {
        return base.Channel.GetAddressInfoAsync(address);
    }
}

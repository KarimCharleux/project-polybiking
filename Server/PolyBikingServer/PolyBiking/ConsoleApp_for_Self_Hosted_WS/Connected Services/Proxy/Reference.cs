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
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Position", Namespace="http://schemas.datacontract.org/2004/07/Proxy_Cache_Server")]
    [System.SerializableAttribute()]
    public partial class Position : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private double LatField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private double LngField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public double Lat {
            get {
                return this.LatField;
            }
            set {
                if ((this.LatField.Equals(value) != true)) {
                    this.LatField = value;
                    this.RaisePropertyChanged("Lat");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public double Lng {
            get {
                return this.LngField;
            }
            set {
                if ((this.LngField.Equals(value) != true)) {
                    this.LngField = value;
                    this.RaisePropertyChanged("Lng");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="Proxy.IProxyService")]
    public interface IProxyService {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetStationInfo", ReplyAction="http://tempuri.org/IProxyService/GetStationInfoResponse")]
        string GetStationInfo();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetStationInfo", ReplyAction="http://tempuri.org/IProxyService/GetStationInfoResponse")]
        System.Threading.Tasks.Task<string> GetStationInfoAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetRouteInfo", ReplyAction="http://tempuri.org/IProxyService/GetRouteInfoResponse")]
        string GetRouteInfo(PolyBiking.Proxy.Position start, PolyBiking.Proxy.Position end);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProxyService/GetRouteInfo", ReplyAction="http://tempuri.org/IProxyService/GetRouteInfoResponse")]
        System.Threading.Tasks.Task<string> GetRouteInfoAsync(PolyBiking.Proxy.Position start, PolyBiking.Proxy.Position end);
        
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
        
        public string GetRouteInfo(PolyBiking.Proxy.Position start, PolyBiking.Proxy.Position end) {
            return base.Channel.GetRouteInfo(start, end);
        }
        
        public System.Threading.Tasks.Task<string> GetRouteInfoAsync(PolyBiking.Proxy.Position start, PolyBiking.Proxy.Position end) {
            return base.Channel.GetRouteInfoAsync(start, end);
        }
        
        public string GetAddressInfo(string address) {
            return base.Channel.GetAddressInfo(address);
        }
        
        public System.Threading.Tasks.Task<string> GetAddressInfoAsync(string address) {
            return base.Channel.GetAddressInfoAsync(address);
        }
    }
}

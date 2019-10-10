import React from 'react'
import './input.css'
export default class Input extends React.Component {

    render() {
        return <div className="form-group">
            <label htmlFor="exampleInputEmail1">{this.props.label}</label>
            <input
                onChange={this.props.handdleChange}
                value={this.props.value}
                type={this.props.type}
                className="form-control"
                name={this.props.name}
                placeholder={this.props.placeholder} 
                />
        </div>
    }

}
import React, { Component } from 'react';
import { Table, Grid, Modal, Button, FormGroup, ControlLabel, FormControl } from 'react-bootstrap';
import './App.css';
import Api from './Api';
import Data from './Data';

const EventRow = ({event}) => {
  return (
    <tr>
      <td>{event.name}</td>
      <td>{event.date}</td>
      <td>{event.venue.name}</td>
      <td>{event.venue.city}</td>
      <td>{event.venue.state}</td>
    </tr>
  );
}

const EventTable = ({events}) => {
  return (
      <Table striped bordered condensed hover>
        <thead>
          <tr>
            <th>Event Name</th>
            <th>Date</th>
            <th>Venue</th>
            <th>City</th>
            <th>State</th>
          </tr>
        </thead>
        <tbody>
          {events.map(event => <EventRow key={event.id} event={event} />)}
        </tbody>
      </Table>
  );
}

class App extends Component {

  constructor(props, context) {
    super(props, context);
    this.state = { 
      events : [],
      show : false,
      name : "",
      date : new Date(),
      vname : "",
      vcity : "",
      vstate : ""
    };
  }

  handleClose = () => {
    this.setState({ show: false });
  }

  handleShow = () => {
    this.setState({ show: true });
  }

  setEvents(events) {
    this.setState({events : events});
  }

  addEvent(event) {
    this.setState({events : [...this.state.events, event]});
    this.handleClose();
  }

  componentDidMount() {
    Api.getEvents().then(events => this.setEvents(events));
    this.setState({vstate : Data.states[0]});
  }

  createEvent = event => {
    event.preventDefault();
    Api.createEvent(this.mapToEvent()).then(event => this.addEvent(event));
  }

  handleChange = control => {
    this.setState({[control.target.name] : control.target.value});
  }

  mapToEvent() {
    return {name : this.state.name, date : this.state.date,
      venue : {name : this.state.vname, city : this.state.vcity, state : this.state.vstate}
    };
  }

  render() {
    return (
      <div className="App">
        <Grid><EventTable events={this.state.events} /></Grid>
        <Button type="button" onClick={this.handleShow}>Add Event</Button>
        <Modal show={this.state.show} onHide={this.handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Add New Event</Modal.Title>
          </Modal.Header>
          <Modal.Body>
              <form onSubmit={this.createEvent}>
              <FormGroup>
                <ControlLabel>Event information</ControlLabel>
                <FormControl
                    type="text"
                    name="name"
                    placeholder="Event name"
                    onChange={this.handleChange}
                  />
                  <FormControl
                    type="date"
                    name="date"
                    placeholder="Date"
                    onChange={this.handleChange}
                  />
              </FormGroup>

              <FormGroup>
                <ControlLabel>Venue information</ControlLabel>
                <FormControl
                    type="text"
                    name="vname"
                    placeholder="Venue name"
                    onChange={this.handleChange}
                  />
                  <FormControl
                    type="text"
                    name="vcity"
                    placeholder="City"
                    onChange={this.handleChange}
                  />
                  <FormControl 
                    componentClass="select"
                    placeholder="select"
                    name="vstate"
                    onChange={this.handleChange}>
                    {Data.states.map((state, index) => <option key={index} value={state}>{state}</option>)}
                  </FormControl>
              </FormGroup>
                <Button type="submit">Add Event</Button>
              </form>
          </Modal.Body>
        </Modal>
      </div>
    );
  }
}

export default App;

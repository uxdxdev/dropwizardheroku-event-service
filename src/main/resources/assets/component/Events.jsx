class Events extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      events: []
    };
  }

  componentDidMount() {
    axios.get(`https://dropwizardheroku-event-service.herokuapp.com/v1/api/events`)
      .then(res => {
        const events = res.data.list;
        this.setState({ events });
      });
  }

  render() {
    return (
      <div>
        <h1>{`Events`}</h1>
        <ul>
          {this.state.events.map((event, index) =>
            <li key={index}>{event.name}</li>
          )}
        </ul>
      </div>
    );
  }
}

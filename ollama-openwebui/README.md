### Project setup

#### Duck DNS

1. Sign up for a free account at <a href="https://www.duckdns.org" target="_blank">DuckDNS</a>.
2. Create a subdomain (e.g., `example`).
3. Update your DNS settings to point the subdomain to your server's IP address.

#### Docker Compose

```bash
docker compose up -d
```

#### Accessing Nginx Proxy Manager Admin Page

Nginx Proxy Manager exposes an admin console on port 81. 

Add SSL certificate from Duck DNS:
- Go to the "SSL Certificates" section.
- Click "Add Certificate".
- Select "Duck DNS" as the type.
- Enter your subdomain and token.

Add Proxy host:
- Go to the "Proxy Hosts" section.
- Click "Add Proxy Host".
- Set the domain name to your DuckDNS subdomain (e.g., `example.duckdns.org`).
- Forward the port to the appropriate service running on your server.

#### Accessing OpenWebUI

Once Nginx Proxy Manager is set up, you can access OpenWebUI via your DuckDNS subdomain.

Fill in openwebui's subdomain to it Webhook URL.

#### Troubleshooting

[TBD]